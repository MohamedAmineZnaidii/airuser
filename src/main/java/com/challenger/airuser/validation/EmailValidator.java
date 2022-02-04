package com.challenger.airuser.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created By ZNAIDI :)
 */

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN);

    /**
     * Validate email pattern
     * @param email email address
     * @param constraintValidatorContext validator context
     * @return true if email is valid format string@string.string
     */
    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return isValidEmail(email);
    }

    private boolean isValidEmail(String email){
        Matcher matcher=PATTERN.matcher(email);
        return matcher.matches();
    }
}
