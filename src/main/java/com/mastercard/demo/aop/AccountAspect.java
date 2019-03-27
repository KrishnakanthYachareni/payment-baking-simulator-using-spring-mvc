/*
 * Copyright (c) 2019 KrishnakanthYachareni. All rights reserved.
 */

package com.mastercard.demo.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.mastercard.demo.dao.AccountDao;
import com.mastercard.demo.exception.KRPaymentException;
import com.mastercard.demo.model.Account;

@Aspect
@Component
public class AccountAspect {

    private static final Logger LOGGER = Logger.getLogger(AccountAspect.class);

    @Before("execution(* com.mastercard.demo.dao.AccountDaoImpl.saveAccount(..))")
    public void validateAccount(JoinPoint joinpoint) {
        LOGGER.info("Method: ValidateAccount is being processed");
        Object[] args = joinpoint.getArgs();
        Account account = (Account)args[0];
        AccountDao accountDao = (AccountDao)joinpoint.getTarget();
        int accountNo = account.getAccountNo();
        if (null != accountDao.getAccount(accountNo)) {
            throw new KRPaymentException("Account with Account Number " + accountNo + " is already exists.");
        }
    }
}
