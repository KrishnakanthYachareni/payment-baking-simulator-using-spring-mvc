/*
 * Copyright (c) 2019 KrishnakanthYachareni. All rights reserved.
 */

package com.mastercard.demo.entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class AccountEntity {

    @Id
    @Column(name = "accountNo")
    private Integer accountNo;

    @Column(name = "accountHolderName")
    private String accountHolderName;

    @Column(name = "balance")
    private Integer balance;

    @Column(name = "accountType")
    private String accountType;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "krCode")
    private String krCode;

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