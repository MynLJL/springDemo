package com.myn.demo.springdemo.restful;


public class RestfulResponse {
    private static String success = "success";
    private static String failed = "failed";
    private static Integer ZERO = 0;

    private Integer code;
    private String message;
    private Object data;

    public RestfulResponse(Object data) {
        this.code = ZERO;
        this.message = success;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
