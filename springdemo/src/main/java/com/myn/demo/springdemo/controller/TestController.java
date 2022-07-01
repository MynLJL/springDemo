package com.myn.demo.springdemo.controller;

import com.myn.demo.springdemo.restful.RestfulResponse;
import com.myn.demo.springdemo.service.PtBenefitCouponService;
import com.myn.demo.springdemo.util.ThreadLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@Controller
@Slf4j
public class TestController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private PtBenefitCouponService ptBenefitCouponService;

    @ResponseBody
    @GetMapping("/hello")
    public String test() {
        log.info("第一个接口");
        return ThreadLocalUtils.getUserInfo();
    }

    @GetMapping("/Rkey")
    @ResponseBody
    public String Rget(String key) {
        return redisTemplate.opsForValue().get(key);
    }


    @GetMapping("/res")
    @ResponseBody
    public RestfulResponse getRes() {
        return new RestfulResponse(1);
    }
}
