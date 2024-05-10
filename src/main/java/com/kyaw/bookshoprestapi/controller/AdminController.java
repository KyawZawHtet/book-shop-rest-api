/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 6:07 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.controller;

import com.kyaw.bookshoprestapi.dto.AdminDto;
import com.kyaw.bookshoprestapi.service.AdminService;
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
        name = "CRUD REST APIs for Admin",
        description = "CRUD REST APIs - Create Admin, Update Admin, Get Admin By Id, Get All Admins, Delete Admin"
)
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/admins")
public class AdminController {

    private AdminService adminService;

    @Operation(
            summary = "Get All Admin REST API",
            description = "Get All Admin REST API is used to get all the admins from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins(){

        List<AdminDto> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Admin By Id REST API",
            description = "Get Admin By Id REST API is used to get a single admin from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @GetMapping("{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long adminId){
        AdminDto admin = adminService.getAdminById(adminId);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @Operation(
            summary = "Create Admin REST API",
            description = "Create Admin REST API is used to save admin in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<AdminDto> createAdmin(@Valid @RequestBody AdminDto admin){

        AdminDto createAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createAdmin, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Update Admin REST API",
            description = "Update Admin REST API is used to update a particular admin in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @PutMapping("{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable("id") Long adminId, @RequestBody @Valid AdminDto admin){

        admin.setId(adminId);
        AdminDto updatedAdmin = adminService.updateAdmin(admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete Admin REST API",
            description = "Delete Admin REST API is used to delete a particular admin from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long adminId){

        adminService.deleteAdmin(adminId);
        return new ResponseEntity<>("Admin Successfully Deleted!", HttpStatus.OK);
    }
}
