package com.challenger.airuser.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

/**
 * Created By ZNAIDI :)
 */

public class AgeValidator implements ConstraintValidator<ValidAge,LocalDate> {
    /**
     * validate age
     * @param birthDate LocalDate
     * @param constraintValidatorContext validator context
     * @return true if age is superior than 18 years old
     */
    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext constraintValidatorContext) {
        LocalDate curDate = LocalDate.now();
        final int MINIMUM_AGE_TO_REGISTER = 18;
        return Period.between(birthDate, curDate).getYears()>= MINIMUM_AGE_TO_REGISTER;
    }
}
