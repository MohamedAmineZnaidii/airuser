package com.challenger.airuser.validation;

import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AgeValidatorTest {

    @Test
    void isValid() {
        //this case is valid if you are running the project before 2038-01-01
        final String invalidBirthDateString="2020-01-01";
        LocalDate invalidBirthDate= LocalDate.parse(invalidBirthDateString);;
        final String validBirthDateString="2000-01-01";
        LocalDate validBirthdate= LocalDate.parse(validBirthDateString);;
        AgeValidator ageValidator= new AgeValidator();

        assertTrue(ageValidator.isValid(validBirthdate, null ));
        assertFalse(ageValidator.isValid(invalidBirthDate, null ));

    }
}