package com.akadev.lms_backend.mapper;

import com.akadev.lms_backend.dto.UserDto;
import com.akadev.lms_backend.entity.User;

public class UserMapper {

    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFirstname(),
                user.getLastName(),
                user.getEmail(),
                user.getRole()
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getEmail(),
                userDto.getRole()
        );
    }

}
