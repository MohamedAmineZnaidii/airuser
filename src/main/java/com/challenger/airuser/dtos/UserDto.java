package com.challenger.airuser.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * Created By ZNAIDI :)
 */
@Data
public class UserDto {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String country;
    @JsonFormat(pattern = "yyyy-dd-MM")
    private LocalDate birthDate;
    private String email;
    private String phoneNumber;
}
