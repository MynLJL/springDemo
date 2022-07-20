package com.myn.demo.springdemo.controller;

public class test {
    public static void main(String[] args) {
        String[] strs = {"dog","racecar","car"};
        System.out.println(test(strs));
    }
    public static String test(String[] inputs) {
        StringBuilder sb = new StringBuilder();
        int[] lens = new int[inputs.length];
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i].length() > 0) {
                lens[i] = inputs.length;
                minLen = Math.min(minLen, inputs[i].length());
            } else {
                return "";
            }
        }
        for (int i = 0; i < minLen; i++) {
            char ch = inputs[0].charAt(i);
            if (judge(inputs, ch, i)) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }
    public static boolean judge(String[] inputs, char ch, int index) {
        int len = inputs.length - 1;
        while (len >= 0) {
            if (inputs[len].charAt(index) != ch) {
                return false;
            }
            len--;
        }
        return true;
    }
}

/*public class Singleton {
    private Singleton () {

    }
    private static final Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }
}*/