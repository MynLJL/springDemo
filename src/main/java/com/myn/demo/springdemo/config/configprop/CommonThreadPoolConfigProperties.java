package com.myn.demo.springdemo.config.configprop;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.concurrent.RejectedExecutionHandler;

@ConfigurationProperties(prefix = "thread.pool")
@Data
public class CommonThreadPoolConfigProperties implements InitializingBean {
    private Integer coreSize;
    private Integer maxSize;
    private Integer keepAliveSeconds;
    private String  threadNamePrefix;
    @Override
    public void afterPropertiesSet() throws Exception {
        if (null == coreSize || null == maxSize || null == threadNamePrefix) {
            throw new Exception("线程池参数缺失");
        }
    }
}
