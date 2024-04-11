package com.alokpau.springbootrest.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ValidationAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidationAspect.class);

    @Around("execution(* com.alokpau.springbootrest.service.JobService.*(..)) && args(postId)")
    public Object validateAndUpdate(ProceedingJoinPoint pjp, int postId) throws Throwable {
        if(postId < 0) {
            LOGGER.info("post id is negative.");
            postId *= -1;
            LOGGER.info("updated post id is " + postId);
        }
        Object obj = pjp.proceed(new Object[]{postId});
        return obj;
    }
}
