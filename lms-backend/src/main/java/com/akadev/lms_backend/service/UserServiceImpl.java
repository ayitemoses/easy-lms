package com.akadev.lms_backend.service;

import com.akadev.lms_backend.dto.UserDto;
import com.akadev.lms_backend.entity.User;
import com.akadev.lms_backend.expection.ResourceNotFoundException;
import com.akadev.lms_backend.mapper.UserMapper;
import com.akadev.lms_backend.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {


    // Create the circular references
    
    //private final UserService userService;
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
        // Il faut gérer l'exception en cas de recherche infructueuse
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User does not exist with the given id: " + userId));

        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
       List<User> users = userRepository.findAll();
        //Comme la méthode reçoit exactement le même paramètre que celui fourni par le Stream, Java permet cette syntaxe raccourcie :
        // remplace lambda by method reference
       return users.stream().map(UserMapper::mapToUserDto).collect(Collectors.toList());

       // Lambda Expression
        //return users.stream().map((user) -> UserMapper.mapToUserDto(user)).collect(Collectors.toList());

    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with the given id: " + userId));

        user.setFirstname(updatedUser.getFirstName());
        user.setLastName(updatedUser.getLastName());
        user.setEmail(updatedUser.getEmail());
        user.setRole(updatedUser.getRole());

        User updatedUserObj = userRepository.save(user);
        return UserMapper.mapToUserDto(updatedUserObj);
    }

    @Override
    public void deleteUser(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User does not exist with the given id: " + userId));

        userRepository.deleteById(userId);

    }
}
