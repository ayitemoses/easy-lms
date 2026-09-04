package com.akadev.lms_backend.service;

import com.akadev.lms_backend.dto.UserDto;
import com.akadev.lms_backend.entity.User;
import com.akadev.lms_backend.mapper.UserMapper;
import com.akadev.lms_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convertir userDto en User
        User user = UserMapper.mapToUser(userDto);
        // enregistrer dans le repository
        User savedUser = userRepository.save(user);
        // Convertir User to userDto et le retourner au client
        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        return null;
    }

    @Override
    public void deleteUser(Long userId) {

    }
}
