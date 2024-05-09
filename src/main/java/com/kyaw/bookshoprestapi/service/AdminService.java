/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 3:24 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.service;

import com.kyaw.bookshoprestapi.dto.AdminDto;
import com.kyaw.bookshoprestapi.model.Admin;

import java.util.List;

public interface AdminService {

    List<AdminDto> getAllAdmins();

    AdminDto getAdminById(Long adminId);

    AdminDto createAdmin(AdminDto adminDto);

    AdminDto updateAdmin(AdminDto adminDto);

    void deleteAdmin(Long adminId);
}
