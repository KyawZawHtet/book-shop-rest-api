/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/10/2024
 * @Time : 1:19 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.dto;

import com.kyaw.bookshoprestapi.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;

    @Schema(description = "Name")
    @NotEmpty(message = "Name should not be null or empty")
    private String name;

    @Schema(description = "Email")
    @NotEmpty(message = "Email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;

    @Schema(description = "Password")
    @NotEmpty(message = "Password should not be null or empty")
    private String password;

    @Schema(description = "Phone")
    @NotEmpty(message = "Phone should not be null or empty")
    private String phone;

    private LocalDate dateOfBirth;

    @Schema(description = "Age")
    @NotEmpty(message = "Age should not be null or empty")
    private String age;

    private Gender gender;

    @Schema(description = "Level")
    @NotEmpty(message = "Level should not be null or empty")
    private String level;

    private boolean erase;
}
