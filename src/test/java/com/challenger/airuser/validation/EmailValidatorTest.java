package com.challenger.airuser.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmailValidatorTest {

    @Test
    void isValid() {
        final String validEmail="test@test.com";
        final String inValidEmail="test.com";

        EmailValidator emailValidator=new EmailValidator();
        assertTrue(emailValidator.isValid(validEmail, null ));
        assertFalse(emailValidator.isValid(inValidEmail, null ));
    }
}