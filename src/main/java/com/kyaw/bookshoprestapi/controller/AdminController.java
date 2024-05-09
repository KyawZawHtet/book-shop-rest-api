/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 6:07 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.controller;

import com.kyaw.bookshoprestapi.dto.AdminDto;
import com.kyaw.bookshoprestapi.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/admins")
public class AdminController {

    private AdminService adminService;

    @GetMapping
    public ResponseEntity<List<AdminDto>> getAllAdmins(){

        List<AdminDto> admins = adminService.getAllAdmins();
        return new ResponseEntity<>(admins, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable("id") Long adminId){
        AdminDto admin = adminService.getAdminById(adminId);
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto admin){

        AdminDto createAdmin = adminService.createAdmin(admin);
        return new ResponseEntity<>(createAdmin, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<AdminDto> updateAdmin(@PathVariable("id") Long adminId, @RequestBody AdminDto admin){

        admin.setId(adminId);
        AdminDto updatedAdmin = adminService.updateAdmin(admin);
        return new ResponseEntity<>(updatedAdmin, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("id") Long adminId){

        adminService.deleteAdmin(adminId);
        return new ResponseEntity<>("Admin Successfully Deleted!", HttpStatus.OK);
    }
}
