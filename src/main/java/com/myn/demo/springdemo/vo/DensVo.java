package com.myn.demo.springdemo.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.myn.demo.springdemo.annotation.Sensitive;
import com.myn.demo.springdemo.enums.SensitiveStrategy;
import lombok.Data;

@Data
public class DensVo {
    @Sensitive(strategy = SensitiveStrategy.PHONE)
    @JsonProperty(value = "phonePlain")
    private String phonePlain;
}
