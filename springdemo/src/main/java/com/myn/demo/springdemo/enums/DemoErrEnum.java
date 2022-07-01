package com.myn.demo.springdemo.enums;

public enum DemoErrEnum implements BaseEnum {

    SERVER_ERR(1, ""),
    ;

    private Integer code;
    private String msg;

    private  DemoErrEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
