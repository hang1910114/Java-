package com.neu.api.interceptor;

import com.neu.api.properties.JWTProperties;
import com.neu.api.utils.JSONUtil;
import com.neu.api.utils.JWTUtil;
import com.neu.api.utils.Result;
import com.neu.api.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 判断是否有登录的拦截器
 */

@Component
public class AdminLoginInterceptor implements HandlerInterceptor {

    @Resource
    JWTProperties jwtProperties;



    //前提
        //如果登录成功后,每次请求都要把token携带到服务器
                           //如何携带
                              //约定:每次发请求的时候将token放入到请求头中，名字为token


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //OPTIONS
        if(request.getMethod().equals(RequestMethod.OPTIONS.name())){
            return true;
        }

        //怎么判断当前请求是否已登录了呢？
            //从请求头中获取token,然后判断是否有效
                //token都没有
                //token有
                    //判断token的合法性

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
                JWTUtil.parseJWT(token,jwtProperties.getSecure());
                return true;
            }catch (Exception e){
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
}
