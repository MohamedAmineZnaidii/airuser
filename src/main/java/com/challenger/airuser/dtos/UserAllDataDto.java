package com.challenger.airuser.dtos;

import com.challenger.airuser.validation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * Created By ZNAIDI :)
 */
@Data
@ValidPasswordMatch
public class UserAllDataDto {
    @NotNull
    @Size(min = 1, message = "First Name is Required")
    private String firstName;
    @NotNull
    @Size(min = 1, message = "Last Name is Required")
    private String lastName;
    private String street;
    private String city;

    @ValidCountry
    @NotNull
    @Size(min = 1, message = "{Size.userDto.country}")
    private String country;

    @JsonFormat(pattern = "yyyy-dd-MM")
    @ValidAge
    private LocalDate birthDate;

    @ValidEmail
    @NotNull
    @Size(min = 1, message = "{Size.userDto.email}")
    private String email;
    @ValidPassword
    private String password;
    @ValidPassword
    private String passwordConfirmation;

    private String phoneNumber;
}
