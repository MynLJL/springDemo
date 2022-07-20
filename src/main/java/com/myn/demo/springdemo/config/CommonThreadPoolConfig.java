package com.myn.demo.springdemo.config;

import com.myn.demo.springdemo.config.configprop.CommonThreadPoolConfigProperties;
import com.myn.demo.springdemo.pool.CommonThreadPoolExecutor;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableConfigurationProperties(CommonThreadPoolConfigProperties.class)
public class CommonThreadPoolConfig implements AsyncConfigurer {

    @Autowired
    CommonThreadPoolConfigProperties commonThreadPoolConfigProperties;

    @Bean
    public ThreadPoolTaskExecutor buildThreadPool() {
        ThreadPoolTaskExecutor executor = new CommonThreadPoolExecutor();
        executor.setCorePoolSize(commonThreadPoolConfigProperties.getCoreSize());
        executor.setMaxPoolSize(commonThreadPoolConfigProperties.getMaxSize());
        executor.setKeepAliveSeconds(commonThreadPoolConfigProperties.getKeepAliveSeconds());
        executor.setThreadNamePrefix(commonThreadPoolConfigProperties.getThreadNamePrefix());
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.afterPropertiesSet();
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return buildThreadPool();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return AsyncConfigurer.super.getAsyncUncaughtExceptionHandler();
    }
}
