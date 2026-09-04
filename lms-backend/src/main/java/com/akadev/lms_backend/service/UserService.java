package com.akadev.lms_backend.service;

import com.akadev.lms_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    //Create
    UserDto createUser(UserDto userDto);
    // Read
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    //update
    UserDto updateUser(Long userId, UserDto userDto);
    // Delete
    void deleteUser(Long userId);
}
