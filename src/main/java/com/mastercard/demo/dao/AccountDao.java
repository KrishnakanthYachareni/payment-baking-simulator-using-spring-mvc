/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.dao;

import java.util.List;

import com.mastercard.demo.model.Account;

public interface AccountDao {
    boolean saveAccount(Account account);

    List<Account> getAccounts();

    Account getAccount(Integer accountNo);

    boolean deleteAccount(int accountNo);
}