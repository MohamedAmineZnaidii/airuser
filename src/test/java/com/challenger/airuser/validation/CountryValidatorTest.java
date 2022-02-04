package com.challenger.airuser.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryValidatorTest {

    @Test
    void isValid() {
        final String validCountry="France";
        final String invalidCountry="USA";
        CountryValidator countryValidator= new CountryValidator();

        assertTrue(countryValidator.isValid(validCountry, null ));
        assertFalse(countryValidator.isValid(invalidCountry, null ));
    }
}