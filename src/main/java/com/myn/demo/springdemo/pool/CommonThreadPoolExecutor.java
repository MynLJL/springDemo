package com.myn.demo.springdemo.pool;

import com.myn.demo.springdemo.util.ThreadLocalUtils;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Map;

@Slf4j
public class CommonThreadPoolExecutor extends ThreadPoolTaskExecutor {

    @Override
    public void execute(Runnable task) {
        Map<String, String> map = MDC.getCopyOfContextMap();
        super.execute(() -> {
               MDC.setContextMap(map);
               try {
                   task.run();
               } finally {
                   MDC.clear();
               }
            });
    }
}
