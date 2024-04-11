package com.alokpau.springbootrest.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    // return_type fully_qualified_class_name.method_name(args)
    @Before("execution(* com.alokpau.springbootrest.service.JobService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        LOGGER.info("method going to call :: " + jp.getSignature().getName());
    }

    @After("execution(* com.alokpau.springbootrest.service.JobService.*(..))")
    public void logMethodCalled(JoinPoint jp) {
        LOGGER.info("method is called finally :: " + jp.getSignature().getName());
    }

    @AfterReturning("execution(* com.alokpau.springbootrest.service.JobService.*(..))")
    public void logMethodCalledSuccess(JoinPoint jp) {
        LOGGER.info("method is called successfully :: " + jp.getSignature().getName());
    }
}
