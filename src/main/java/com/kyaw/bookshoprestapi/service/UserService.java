/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/10/2024
 * @Time : 1:20 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.service;

import com.kyaw.bookshoprestapi.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> getAllUsers();

    UserDto getByUserId(Long userId);

    UserDto createUser(UserDto userDto);

    UserDto updateUser(UserDto userDto);

    void deleteUser(Long userId);
}

