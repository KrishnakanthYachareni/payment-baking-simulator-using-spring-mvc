/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class ExceptionHandlerAspect {

    private static final org.apache.log4j.Logger LOGGER = Logger.getLogger(LoggingAspect.class);

    @AfterThrowing(pointcut = "@annotation(handler)", throwing = "ex")
    public void handleException(Catch handler, Throwable ex) {
        try {
            if (ex instanceof RuntimeException) {
                throw (RuntimeException)handler.targetException().newInstance();
            }
        } catch (IllegalAccessException | InstantiationException e) {
            LOGGER.error("Unexpected exception while handling exception :{0}", e.getCause());
        }
    }


   /* @Around("@annotation(log)")
    public void methodLogging(ProceedingJoinPoint joinPoint, Catch log) throws Throwable {
        try {
            String methodName = joinPoint.getSignature().toShortString();
            LOGGER.info("Info: In & Before Advice: Calling the method: " + methodName);
            joinPoint.proceed();
            LOGGER.info("Info: Method Returning : " + methodName);
        } catch (RuntimeException e) {
            throw (Throwable)log.targetException().newInstance();
        }
        Class returnType = ((MethodSignature)joinPoint.getSignature()).getReturnType();
        LOGGER.info("Executing finished " + returnType.getSimpleName());
    }*/

    @Before("@annotation(log)")
    public void before(JoinPoint joinPoint, Catch log) {
        String methodName = joinPoint.getSignature().toShortString();
        LOGGER.info("Info: In & Before Advice: Calling the method: " + methodName);
    }

    @AfterReturning(pointcut = "@annotation(log)", returning = "result")
    public void after(JoinPoint joinPoint, Object result, Catch log) {
        String methodName = joinPoint.getSignature().toShortString();
        LOGGER.info("Info: In @AfterReturning: From Method: " + methodName);
        LOGGER.info("Info: Data Returned by Method: " + result);
    }
}


