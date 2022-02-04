package com.challenger.airuser.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


/**
 * Created By ZNAIDI :)
 */

public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {
    /**
     *
     * @param password password to validate
     * @param constraintValidatorContext validator context
     * @return true if password legnt is sup than 8 and inf than 30
     */
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        return password.length() >= 8 && password.length() < 30;
    }
}
