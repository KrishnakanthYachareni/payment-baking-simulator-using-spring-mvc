/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.mastercard.demo.entity.AccountEntity;
import com.mastercard.demo.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean saveAccount(Account account) {
        boolean saveFlag = true;
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNo(account.getAccountNo());
        accountEntity.setAccountHolderName(account.getAccountHolderName());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setAccountType(account.getAccountType());
        accountEntity.setDateOfBirth(account.getDateOfBirth());
        accountEntity.setKrCode(account.getKrCode());
        try {
            entityManager.persist(accountEntity);
        } catch (Exception ex) {
            ex.getStackTrace();
            saveFlag = false;
        }
        return saveFlag;
    }
}