/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 3:21 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.dto;

import com.kyaw.bookshoprestapi.enums.AccountStatus;
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

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {

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

    private AccountStatus accountStatus;

    private boolean erase;
}
