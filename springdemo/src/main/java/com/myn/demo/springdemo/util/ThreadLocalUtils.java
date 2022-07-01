package com.myn.demo.springdemo.util;

public class ThreadLocalUtils {

    public static String  getUserInfo() {
        return userInfo.get();
    }

    public static void setUserInfo(String user) {
        userInfo.set(user);
    }

    public final static ThreadLocal<String> userInfo = ThreadLocal.withInitial(() -> {return "";});
}
