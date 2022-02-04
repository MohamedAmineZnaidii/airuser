package com.challenger.airuser.validation;

import com.challenger.airuser.dtos.UserAllDataDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created By ZNAIDI :)
 */

public class PasswordMatchesValidator implements ConstraintValidator<ValidPasswordMatch,UserAllDataDto> {
    /**
     *
     * @param userAllDataDto userDto with password information
     * @param constraintValidatorContext validator context
     * @return true if password is confirmed by the user
     */
    @Override
    public boolean isValid(UserAllDataDto userAllDataDto, ConstraintValidatorContext constraintValidatorContext) {
        return userAllDataDto.getPassword().equals(userAllDataDto.getPasswordConfirmation());
    }
}
