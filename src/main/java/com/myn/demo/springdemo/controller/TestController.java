package com.myn.demo.springdemo.controller;

import com.myn.demo.springdemo.restful.RestfulResponse;
import com.myn.demo.springdemo.service.AsyncService;
import com.myn.demo.springdemo.service.PtBenefitCouponService;
import com.myn.demo.springdemo.util.ThreadLocalUtils;
import com.myn.demo.springdemo.vo.DensVo;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@Controller
@Slf4j
public class TestController {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Autowired
    private PtBenefitCouponService ptBenefitCouponService;
    @Autowired
    private AsyncService asyncService;
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

    @PostMapping("/dens")
    @ResponseBody
    public DensVo dens(@RequestBody DensVo densVo) {
        return densVo;
    }

    @GetMapping("/async")
    @ResponseBody
    public void async() {
        asyncService.execute();
    }
}
