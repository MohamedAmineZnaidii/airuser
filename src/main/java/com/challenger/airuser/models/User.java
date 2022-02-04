package com.challenger.airuser.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.time.LocalDate;

/**
 * Created By ZNAIDI :)
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity (name = "user")
public class User extends BaseEntity{
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String country;
    private LocalDate birthDate;
    @Column(nullable = false,unique = true)
    @EqualsAndHashCode.Include
    private String email;
    private String password;
    private String phoneNumber;

}
