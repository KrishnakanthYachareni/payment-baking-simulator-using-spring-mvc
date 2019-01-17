/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    private static final Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @Pointcut("execution(* com.mastercard.demo.controller.*.*(..))")
    private void forControllerPackage() {
    }

    @Pointcut("execution(* com.mastercard.demo.service.*.*(..))")
    private void forServicePackage() {
    }

    @Pointcut("execution(* com.mastercard.demo.dao.*.*(..))")
    private void forDaoPackage() {
    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forApplication() {
    }

    /*@Before("forApplication()")
    public void before(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().toShortString();
        LOGGER.info("Info: In & Before Advice: Calling the method: " + methodName);
    }

    @AfterReturning(pointcut = "forApplication()", returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().toShortString();
        LOGGER.info("Info: In @AfterReturning: From Method: " + methodName);
        LOGGER.info("Info: Data Returned by Method: " + result);
    }*/
}