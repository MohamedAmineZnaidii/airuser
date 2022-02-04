package com.challenger.airuser.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created By ZNAIDI :)
 */

public class CountryValidator implements ConstraintValidator<ValidCountry,String> {

    /**
     *
     * @param countryName country name to validate
     * @param constraintValidatorContext validator context
     * @return true if country is France
     */
    @Override
    public boolean isValid(String countryName, ConstraintValidatorContext constraintValidatorContext) {
        return isValidCountry(countryName);
    }

    private boolean isValidCountry(String country){
        final String VALID_COUNTRY_NAME="france";
        return country.equalsIgnoreCase(VALID_COUNTRY_NAME);
    }
}
