package com.myn.demo.springdemo.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.myn.demo.springdemo.enums.SensitiveStrategy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义jackson注解，标注在属性上
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@JacksonAnnotationsInside
// @JsonSerialize注解,主要用于数据转换,该注解作用在该属性的getter()方法上
@JsonSerialize(using = SensitiveJsonSerializer.class)
public @interface Sensitive {
    //脱敏策略
    SensitiveStrategy strategy();
}
