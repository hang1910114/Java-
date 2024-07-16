package com.neu.api.interceptor;

import com.neu.api.properties.JWTProperties;
import com.neu.api.utils.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * 判断是否有登录的拦截器
 */

@Component
public class AppLoginInterceptor implements HandlerInterceptor {
    @Resource
    JWTProperties jwtProperties;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //OPTIONS
        if(request.getMethod().equals(RequestMethod.OPTIONS.name())){
            return true;
        }

        String token = request.getHeader("token");
        if(StringUtil.isEmpty(token)){
            response.setStatus(401);
            //请求头中没有token
            response.setContentType("application/json;charset=utf-8");
            PrintWriter printWriter =  response.getWriter();

            printWriter.print(JSONUtil.objToJson(Result.failure("请重新登录")));
            return false;
        }else{
            //判断token的合法性
            try{
                Map<String,Object> claimInfo =  JWTUtil.parseJWT(token,jwtProperties.getSecure());

                Long customerId = (long)(int)claimInfo.get(JWTUtil.CUSTOMER_ID);
                //给当前线程绑定数据
                ThreadContextUtil.setData(customerId);
                return true;
            }catch (Exception e){
                e.printStackTrace();
                response.setStatus(401);
                //说明token不合法
                //请求头中没有token
                response.setContentType("application/json;charset=utf-8");
                PrintWriter printWriter =  response.getWriter();
                printWriter.print(JSONUtil.objToJson(Result.failure("token不合法")));
                return false;
            }
        }
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //当控制器方法调用玩执行该方法
        ThreadContextUtil.removeData();
    }
}
