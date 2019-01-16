/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.model;


import java.util.Date;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.mastercard.demo.validation.annotation.KRCode;

public class Account {

    @NotNull
    private Integer accountNo;

    @NotNull
    @Size(min = 2, max = 50, message = "Invalid length for Account Holder Name")
    //@Pattern(regexp = "/^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$/", message = "Invalid Account Holder Name")
    private String accountHolderName;

    @NotNull
    @Min(value = 1000, message = "Minimum balance must not be less than 1000")
    private Integer balance;

    @NotNull
    private String accountType;

    @DateTimeFormat(pattern = "MM/dd/yyyy")
    @NotNull
    @Past(message = "Account can't be created for a person not born")
    private Date dateOfBirth;

    @NotNull
    @KRCode(value = "PSUSA", message = "Security Code should start with PSUSAF")
    //@KRCode //with default messages
    private String krCode;

    public Account() {
        dateOfBirth = new Date();
    }

    public Account(Integer accountNo, String accountHolderName, Integer balance, String accountType,
            Date dateOfBirth, String krCode) {
        this.accountNo = accountNo;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.accountType = accountType;
        this.dateOfBirth = dateOfBirth;
        this.krCode = krCode;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getKrCode() {
        return krCode;
    }

    public void setKrCode(String krCode) {
        this.krCode = krCode;
    }
}