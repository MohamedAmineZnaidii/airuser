package com.challenger.airuser.dtos.mappers;

import com.challenger.airuser.dtos.UserAllDataDto;
import com.challenger.airuser.dtos.UserDto;
import com.challenger.airuser.models.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class UserMapperTest {
    UserMapper userMapper= UserMapper.INSTANCE;
    @Test
    void toEntity()  {
        UserDto userDto= createRandomUserDto();
        User user=userMapper.toEntity(userDto);
        assertEquals(userDto.getEmail(),user.getEmail());
    }

    @Test
    void toDto()  {
        User user=createRandomUser();
        UserDto userDto=userMapper.toDto(user);
        assertEquals(userDto.getEmail(),user.getEmail());
    }


    @Test
    void toUserAllDataDto()  {
        User user=createRandomUser();
        UserAllDataDto userAllDataDto=userMapper.toUserAllDataDto(user);
        assertEquals(userAllDataDto.getEmail(),user.getEmail());
        assertEquals(userAllDataDto.getPassword(),user.getPassword());
    }

    @Test
    void userAllDataDtoToUser()  {
        UserAllDataDto userAllDataDto= createRandomUserAllDataDto();
        User user=userMapper.userAllDataDtoToUser(userAllDataDto);
        assertEquals(userAllDataDto.getEmail(),user.getEmail());
        assertEquals(userAllDataDto.getPassword(),user.getPassword());
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

    private UserDto createRandomUserDto() {
        final String birthDateString="2000-01-01";
        LocalDate birthdate = LocalDate.parse(birthDateString);
        UserDto userDto=new UserDto();
        userDto.setEmail(UUID.randomUUID().toString());
        userDto.setFirstName("firstNameTest");
        userDto.setLastName("lastNameTest");
        userDto.setBirthDate(birthdate);
        userDto.setCity("Antibes");
        userDto.setStreet("The Wonderful street");
        userDto.setCountry("France");
        return  userDto;
    }

    private UserAllDataDto createRandomUserAllDataDto()  {
        final String birthDateString="2000-01-01";
        LocalDate birthdate = LocalDate.parse(birthDateString);
        UserAllDataDto userDto=new UserAllDataDto();
        userDto.setEmail(UUID.randomUUID().toString());
        userDto.setFirstName("firstNameTest");
        userDto.setLastName("lastNameTest");
        userDto.setPassword("Password");
        userDto.setBirthDate(birthdate);
        userDto.setCity("Antibes");
        userDto.setStreet("The Wonderful street");
        userDto.setCountry("France");
        return  userDto;
    }
}