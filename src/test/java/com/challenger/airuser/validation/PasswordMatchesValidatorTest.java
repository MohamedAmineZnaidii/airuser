package com.challenger.airuser.validation;

import com.challenger.airuser.dtos.UserAllDataDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordMatchesValidatorTest {

    @Test
    void isValid() {
        UserAllDataDto validUserPasswordConfirmation= new UserAllDataDto();
        validUserPasswordConfirmation.setPassword("password");
        validUserPasswordConfirmation.setPasswordConfirmation("password");

        UserAllDataDto invalidUserPasswordConfirmation= new UserAllDataDto();
        invalidUserPasswordConfirmation.setPassword("password");
        invalidUserPasswordConfirmation.setPasswordConfirmation("anotherPassword");

        PasswordMatchesValidator passwordMatchesValidator= new PasswordMatchesValidator();
        assertTrue(passwordMatchesValidator.isValid(validUserPasswordConfirmation,null));
        assertFalse(passwordMatchesValidator.isValid(invalidUserPasswordConfirmation,null));

    }
}