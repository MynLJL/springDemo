package com.myn.demo.springdemo.interceptor;

import com.myn.demo.springdemo.util.StringUtils;
import com.myn.demo.springdemo.util.ThreadLocalUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(LogInterceptor.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (StringUtils.isEmpty(request.getHeader("REQUEST_ID"))) {
            MDC.put("REQUEST_ID", UUID.randomUUID().toString().replace("-", ""));
        } else {
            MDC.put("REQUEST_ID", request.getHeader("REQUEST_ID"));
        }
        ThreadLocalUtils.setUserInfo("myn");
        logger.info("【请求开始】url:{}",request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info("【请求结束】url:{}",request.getRequestURI());
    }
}
