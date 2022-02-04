package com.challenger.airuser.controllers.v1;

import com.challenger.airuser.dtos.UserAllDataDto;
import com.challenger.airuser.dtos.UserDto;
import com.challenger.airuser.dtos.mappers.UserMapper;
import com.challenger.airuser.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created By ZNAIDI :)
 */
@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    /**
     *
     * @param userAllDataDto user to add
     * @return UserDto of the created user
     */
    @PostMapping("registration")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto userRegistration(@RequestBody @Valid UserAllDataDto userAllDataDto){
        return userMapper.toDto(userService.save(userMapper.userAllDataDtoToUser(userAllDataDto)));
    }

    /**
     * get a user by his registration email address
     * @param email user's email address
     * @return userDto of founded user
     */
    @GetMapping("get/{email}")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserByEmail(@PathVariable String email){
        return userMapper.toDto(userService.findUserByEmail(email));
    }

    /**
     * get a user by id
     * @param id user id
     * @return userTo of founded user
     */
    @GetMapping("get/")
    @ResponseStatus(HttpStatus.OK)
    public UserDto getUserById(@RequestParam(defaultValue = "1") Long id){
        return userMapper.toDto(userService.findUserByID(id));
    }








}
