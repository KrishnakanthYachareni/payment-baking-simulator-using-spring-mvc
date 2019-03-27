/*
 * Copyright (c) 2019 KrishnakanthYachareni. All rights reserved.
 */

package com.mastercard.demo.dao;

import java.util.ArrayList;
import java.util.List;
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
        AccountEntity accountEntity = transformAccountToEntity(account);
        try {
            // Insert or Update
            entityManager.merge(accountEntity);
        } catch (Exception ex) {
            ex.getStackTrace();
            saveFlag = false;
        }
        return saveFlag;
    }

    @Override
    public List<Account> getAccounts() {
        List<Account> accounts = new ArrayList<>();
        try {
            List<AccountEntity> accountEntities =
                    entityManager.createQuery("From AccountEntity", AccountEntity.class).getResultList();
            for (AccountEntity accountEntity : accountEntities) {
                Account account = transformEntityToAccount(accountEntity);
                accounts.add(account);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accounts;
    }

    @Override
    public Account getAccount(Integer accountNo) {
        try {
            AccountEntity accountEntity = entityManager.find(AccountEntity.class, accountNo);
            if (null != accountEntity) {
                return transformEntityToAccount(accountEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    @Override
    public boolean deleteAccount(int accountNo) {
        AccountEntity accountEntity = entityManager.find(AccountEntity.class, accountNo);
        if (null != accountEntity) {
            entityManager.remove(accountEntity);
            return true;
        }
        return false;
    }

    private AccountEntity transformAccountToEntity(Account account) {
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setAccountNo(account.getAccountNo());
        accountEntity.setAccountHolderName(account.getAccountHolderName());
        accountEntity.setBalance(account.getBalance());
        accountEntity.setAccountType(account.getAccountType());
        accountEntity.setDateOfBirth(account.getDateOfBirth());
        accountEntity.setKrCode(account.getKrCode());
        return accountEntity;
    }

    private Account transformEntityToAccount(AccountEntity accountEntity) {
        Account account = new Account();
        account.setAccountNo(accountEntity.getAccountNo());
        account.setAccountHolderName(accountEntity.getAccountHolderName());
        account.setBalance(accountEntity.getBalance());
        account.setAccountType(accountEntity.getAccountType());
        account.setDateOfBirth(accountEntity.getDateOfBirth());
        account.setKrCode(accountEntity.getKrCode());
        return account;
    }
}