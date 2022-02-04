package com.challenger.airuser.services.impl;

import com.challenger.airuser.exceptions.UserAlreadyExistException;
import com.challenger.airuser.exceptions.UserNotFoundException;
import com.challenger.airuser.models.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
class UserServiceImplTest {


    @Autowired
    private UserServiceImpl userService;

    @Test
    void save()  {
        User user = createRandomUser();
        User createdUser = userService.save(user);
        assertNotNull(createdUser);
        assertNotNull(createdUser.getId());
    }

    @Test
    void findUserByEmail() {
        User user = createRandomUser();
        User createdUser = userService.save(user);
        User searchedUser=userService.findUserByEmail(createdUser.getEmail());
        assertEquals(searchedUser.getEmail(),createdUser.getEmail());
    }

    @Test
    void findUserByID() {
        User user = createRandomUser();
        User createdUser = userService.save(user);
        User searchedUser=userService.findUserByID(createdUser.getId());
        assertEquals(searchedUser.getId(),createdUser.getId());
        assertEquals(searchedUser.getEmail(),createdUser.getEmail());
    }

    @Test
    void throw_Exception_If_Email_Not_Found(){
        assertThrows(UserNotFoundException.class, () -> {
            userService.findUserByEmail(UUID.randomUUID().toString());
        });
    }

    @Test
    void throw_Exception_If_User_Already_Exists(){
        assertThrows(UserAlreadyExistException.class, () -> {
            User user = createRandomUser();
            userService.save(user);
            userService.save(user);

        });
    }

    @Test
    void throw_Exception_If_User_Not_Found(){
        assertThrows(UserNotFoundException.class, () -> {
            userService.findUserByID(new Random().nextLong());
        });
    }

    private User createRandomUser() {
        final String birthDateString="2000-01-01";
        LocalDate birthdate = LocalDate.parse(birthDateString);
        User user=new User();
        user.setEmail(UUID.randomUUID().toString());
        user.setFirstName("firstNameTest");
        user.setLastName("lastNameTest");
        user.setPassword("Password");
        user.setBirthDate(birthdate);
        user.setCity("Antibes");
        user.setStreet("The Wonderful street");
        user.setCountry("France");
        return user;
    }

}