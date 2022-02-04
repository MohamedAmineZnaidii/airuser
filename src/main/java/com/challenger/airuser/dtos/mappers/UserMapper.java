package com.challenger.airuser.dtos.mappers;

import com.challenger.airuser.dtos.UserAllDataDto;
import com.challenger.airuser.dtos.UserDto;
import com.challenger.airuser.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;



/**
 * Created By ZNAIDI :)
 */
@Component
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);

    /**
     * convert userDto to user entity
     * @param userDto userDto without passwords
     * @return User entity
     */
    User toEntity(UserDto userDto);

    /**
     * convert User Entity to userDto without password informatio
     * @param user user entity
     * @return userDto
     */
    UserDto toDto (User user);

    /**
     *  convert user entity to userDto with password information
     * @param user user Entity
     * @return userAllDataDto
     */
    UserAllDataDto toUserAllDataDto(User user);

    /**
     * convert userDtoAllData to user entity
     * @param userAllDataDto userDto with password information
     * @return user Entity
     */
    User userAllDataDtoToUser(UserAllDataDto userAllDataDto);
}

