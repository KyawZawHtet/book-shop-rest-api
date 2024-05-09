/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 3:24 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.service.serviceimpl;

import com.kyaw.bookshoprestapi.dto.AdminDto;
import com.kyaw.bookshoprestapi.exception.EmailAlreadyExitsException;
import com.kyaw.bookshoprestapi.exception.ResourceNotFoundException;
import com.kyaw.bookshoprestapi.model.Admin;
import com.kyaw.bookshoprestapi.repository.AdminRepository;
import com.kyaw.bookshoprestapi.service.AdminService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    private ModelMapper modelMapper;

    @Override
    public List<AdminDto> getAllAdmins() {

        List<Admin> admins = adminRepository.findAll();

        return admins.stream().map((admin -> modelMapper.map(admin, AdminDto.class))).collect(Collectors.toList());
    }

    @Override
    public AdminDto getAdminById(Long adminId) {

        Admin admin = adminRepository.findById(adminId).orElseThrow(
                () -> new ResourceNotFoundException("Admin", "id", adminId)
        );

        return modelMapper.map(admin, AdminDto.class);
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {

        Optional<Admin> optionalAdmin = adminRepository.findByEmail(adminDto.getEmail());
        if(optionalAdmin.isPresent()){
            throw  new EmailAlreadyExitsException("Email already exit for admin.");
        }

        Admin admin = modelMapper.map(adminDto, Admin.class);
        Admin savedAdmin = adminRepository.save(admin);
        AdminDto savedAdminDto = modelMapper.map(savedAdmin, AdminDto.class);

        return savedAdminDto;
    }

    @Override
    public AdminDto updateAdmin(AdminDto adminDto) {

        Admin exitingAdmin = adminRepository.findById(adminDto.getId()).orElseThrow(
                () -> new ResourceNotFoundException("Admin", "id", adminDto.getId())
        );
        exitingAdmin.setName(adminDto.getName());
        exitingAdmin.setEmail(adminDto.getEmail());
        exitingAdmin.setPassword(adminDto.getPassword());
        exitingAdmin.setAccountStatus(adminDto.getAccountStatus());
        exitingAdmin.setErase(adminDto.isErase());

        Admin updatedAadmin = adminRepository.save(exitingAdmin);

        return modelMapper.map(updatedAadmin, AdminDto.class);
    }

    @Override
    public void deleteAdmin(Long adminId) {
        Admin exitingAdmin = adminRepository.findById(adminId).orElseThrow(
                () -> new ResourceNotFoundException("Admin", "id", adminId)
        );
        adminRepository.deleteById(adminId);
    }
}
