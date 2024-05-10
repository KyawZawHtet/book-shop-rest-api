/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/10/2024
 * @Time : 2:06 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.controller;

import com.kyaw.bookshoprestapi.dto.UserDto;
import com.kyaw.bookshoprestapi.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User",
        description = "CRUD REST APIs - Create User, Update User, Get User By Id, Get All Users, Delete User"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private UserService userService;

    @Operation(
            summary = "Get All User REST API",
            description = "Get All User REST API is used to get all the users from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers(){

        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Get User By Id REST API",
            description = "Get User By Id REST API is used to get a single user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getByUserId(@PathVariable("id") Long userId){

        UserDto user = userService.getByUserId(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Create User REST API",
            description = "Create User REST API is used to save user in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto user){

        UserDto createUser = userService.createUser(user);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update User REST API",
            description = "Update User REST API is used to update a particular user in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody @Valid UserDto user){

        user.setId(userId);
        UserDto updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User REST API",
            description = "Delete User REST API is used to delete a particular user from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){

        userService.deleteUser(userId);
        return new ResponseEntity<>("User Successfully Deleted!", HttpStatus.OK);
    }
}
