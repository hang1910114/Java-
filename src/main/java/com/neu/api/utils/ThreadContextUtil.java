package com.neu.api.utils;

public class ThreadContextUtil {

    //作用:就是给当前线程绑定数据的
    private static ThreadLocal<Long> threadLocal = new ThreadLocal<>();

    public static void setData(Long data){
        threadLocal.set(data);
    }

    public static Long getData(){
        return threadLocal.get();
    }

    public static void removeData(){
        threadLocal.remove();
    }
}
