/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.dao;

import com.mastercard.demo.model.Account;

public interface AccountDao {
    boolean saveAccount(Account account);
}