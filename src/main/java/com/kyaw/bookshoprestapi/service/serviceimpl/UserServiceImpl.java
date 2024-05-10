/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/10/2024
 * @Time : 1:20 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.service.serviceimpl;

import com.kyaw.bookshoprestapi.dto.UserDto;
import com.kyaw.bookshoprestapi.exception.EmailAlreadyExitsException;
import com.kyaw.bookshoprestapi.exception.ResourceNotFoundException;
import com.kyaw.bookshoprestapi.model.User;
import com.kyaw.bookshoprestapi.repository.UserRepository;
import com.kyaw.bookshoprestapi.service.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private ModelMapper modelMapper;

    @Override
    public List<UserDto> getAllUsers() {

        List<User> users = userRepository.findAll();

        return users.stream().map((user -> modelMapper.map(user, UserDto.class))).collect(Collectors.toList());
    }

    @Override
    public UserDto getByUserId(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public UserDto createUser(UserDto userDto) {

        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if(optionalUser.isPresent()){
            throw new EmailAlreadyExitsException("Email already exit for user.");
        }

        User user = modelMapper.map(userDto, User.class);
        User savedUser = userRepository.save(user);
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        User exitingUser = userRepository.findById(userDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("User", "Id", userDto.getId())
        );
        exitingUser.setName(userDto.getName());
        exitingUser.setEmail(userDto.getEmail());
        exitingUser.setPassword(userDto.getPassword());
        exitingUser.setPhone(userDto.getPhone());
        exitingUser.setDateOfBirth(userDto.getDateOfBirth());
        exitingUser.setAge(userDto.getAge());
        exitingUser.setGender(userDto.getGender());
        exitingUser.setLevel(userDto.getLevel());
        exitingUser.setErase(userDto.isErase());

        User updatedUser = userRepository.save(exitingUser);

        return modelMapper.map(updatedUser, UserDto.class);
    }

    @Override
    public void deleteUser(Long userId) {

        User exitingUser = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", userId)
        );

        userRepository.deleteById(userId);
    }
}
