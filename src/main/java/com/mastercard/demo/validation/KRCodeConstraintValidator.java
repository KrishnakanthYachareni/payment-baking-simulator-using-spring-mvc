/*
 * Copyright (c) 2019 KrishnakanthYachareni. All rights reserved.
 */

package com.mastercard.demo.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.mastercard.demo.validation.annotation.KRCode;


public class KRCodeConstraintValidator implements ConstraintValidator<KRCode, String> {

    private String codePrefix;

    @Override
    public void initialize(KRCode krCode) {
        codePrefix = krCode.value();
    }

    @Override
    public boolean isValid(String code, ConstraintValidatorContext context) {
        boolean result;
        if (code != null) {
            result = code.startsWith(codePrefix);
        } else {
            result = true;
        }
        return result;
    }
}