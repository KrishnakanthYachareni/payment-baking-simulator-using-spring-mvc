/*
 * Copyright (c) 2019 Mastercard. All rights reserved.
 */

package com.mastercard.demo.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

import com.mastercard.demo.validation.KRCodeConstraintValidator;

@Constraint(validatedBy = KRCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface KRCode {
    String value() default "KR";

    String message() default "Security Code should start with KR";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}