/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mastercard.demo.model.Account;
import com.mastercard.demo.services.AccountService;

@Controller
@RequestMapping("/bankapp")
public class AccountController {

    @Autowired
    private AccountService accountService;

    //  InitBinder annotation works as a pre-processor,when web request comes to the controller this snippet will execute first. Ths  can be used to apply custom rules for the formF
    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, trimmerEditor);
    }

    @RequestMapping("/")
    public String showHomePage() {
        return "index";
    }

    @RequestMapping("/new")
    public String newAccount(Model model) {
        model.addAttribute("account", new Account());
        return "account-form";
    }

    @RequestMapping("/showAccount")
    public String showAccount() {
        return "showAccount";
    }

    @RequestMapping(value = "/saveAccount", method = RequestMethod.POST)
    public String saveAccount(@ModelAttribute("account") @Valid Account account, BindingResult bindingResult) {

        // Method -1
        /*@RequestParam("accountNo") String accountNo,
        @RequestParam("accountHolderName") String customerName,
        @RequestParam("balance") String balance*/

        //Method -2
        /*String accountNo = request.getParameter("accountNo");
        String customerName = request.getParameter("accountHolderName");
        String balance = request.getParameter("balance");*/

        /*
        model.addAttribute("accountNumber", accountNo);
        model.addAttribute("accountHolderName", customerName);
        model.addAttribute("balance", balance);*/

        // Setting Object to model
        /*Account account = new Account();
        account.setAccountNo(Integer.parseInt(accountNo));
        account.setAccountHolderName(customerName);
        account.setBalance(Integer.parseInt(balance));*/

        /*model.addAttribute("account", account);
        return "showAccount";*/

        // bindingResult.rejectValue("accountNo", "error.message.mandatory");
        if (bindingResult.hasErrors()) {
            return "account-form";
        } else {
            accountService.saveAccount(account);
            return "redirect:/bankapp/list";
        }
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listAccounts(Model model) {
        List<Account> accounts = accountService.getAccounts();
        model.addAttribute("accounts", accounts);
        return "listAccounts";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String updateAccount(@RequestParam("accountNo") int accountNo, Model model) {
        Account account = accountService.getAccount(accountNo);
        model.addAttribute("account", account);
        return "account-form";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteAccount(@RequestParam("accountNo") int accountNo, Model model) {
        accountService.deleteAccount(accountNo);
        return "redirect:/bankapp/list";
    }

    // Wrong Resource path handling
    @RequestMapping("*")
    public String fallBackPage() {
        return "fileNotFound";
    }
}