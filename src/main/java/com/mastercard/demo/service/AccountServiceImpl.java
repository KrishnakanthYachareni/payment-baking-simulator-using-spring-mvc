/*
 * Copyright (c) 2019 KrishnakanthYachareni. All rights reserved.
 */

package com.mastercard.demo.service;

import java.util.List;
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

    @Override
    @Transactional
    public List<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    @Override
    @Transactional
    public Account getAccount(Integer accountNo) {
        return accountDao.getAccount(accountNo);
    }

    @Override
    @Transactional
    public boolean deleteAccount(int accountNo) {
        return accountDao.deleteAccount(accountNo);
    }

}