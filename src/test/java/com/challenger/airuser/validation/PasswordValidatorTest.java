package com.challenger.airuser.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void isValid() {
        final String validPassword="Password";
        final String invalidShortPassword="Pass";
        final String invalidLongPassword="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbb";

        PasswordValidator passwordValidator= new PasswordValidator();
        assertTrue(passwordValidator.isValid(validPassword, null ));
        assertFalse(passwordValidator.isValid(invalidShortPassword, null ));
        assertFalse(passwordValidator.isValid(invalidLongPassword, null ));
    }
}