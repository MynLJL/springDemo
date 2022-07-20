package com.myn.demo.springdemo.util;

public class StringUtils {
    public static boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        return str.isEmpty();
    }
}
