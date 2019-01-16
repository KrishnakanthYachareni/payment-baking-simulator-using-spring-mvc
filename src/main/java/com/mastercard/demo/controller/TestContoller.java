/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * This is example of multiple request mapping
 *
 * @RequestParam vs @PathVariable 1. Query string present with URL separated by '?' Vs Part of URL separated by '/' 2.
 * Access key-values of the query string present in the URL Vs Used to match a part of the URL as a Parameter.
 */

@Controller
@RequestMapping("/test")
public final class TestContoller {

    @RequestMapping(value = {"", "/index", "index*", "view/*"})
    public String methodWithMultiResourceNames() {
        return "testRequestMapping";
    }

    @RequestMapping(value = "/name")
    public String methodWithParams(
            @RequestParam(value = "userName", required = false, defaultValue = "Krishnakanth Yachareni")
                    String userName, Model model) {
        System.out.println("Page requested by " + userName);
        model.addAttribute("userName", userName);
        return "testRequestMapping";
    }

    @RequestMapping(value = "/dynamic/{userName}")
    public String dynamicUrl(@PathVariable("userName") String userName) {
        return "testRequestMapping";
    }

    @RequestMapping(value = "/dynamic/{category:[a-z]+}/{userName}")
    public String dynamicUrlWithMulti(@PathVariable("userName") String userName) {
        return "testRequestMapping";
    }

    @RequestMapping("*")
    public String fallBackPage() {
        return "fileNotFound";
    }
}