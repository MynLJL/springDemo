package com.myn.demo.springdemo.serviceImpl;

import com.myn.demo.springdemo.service.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@EnableAsync
public class AsyncServiceImpl implements AsyncService {
    @Override
    @Async
    public void execute() {
        log.info("异步执行，线程名称：{}", Thread.currentThread().getName());
    }
}
