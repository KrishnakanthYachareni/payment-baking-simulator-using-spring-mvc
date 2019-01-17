/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mastercard.demo.dao.AccountDao;
import com.mastercard.demo.model.Account;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    @Transactional
    public boolean saveAccount(Account account) {
        return accountDao.saveAccount(account);
    }
}