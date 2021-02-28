package com.esceer.sdw.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class LoggingAspect {

    @Before("execution(* com.esceer.sdw.controller.*.*(..))")
    public void logBeforeRestCalls(JoinPoint joinPoint) {
        log.info("Incoming rest call: {}", joinPoint);
    }
}
