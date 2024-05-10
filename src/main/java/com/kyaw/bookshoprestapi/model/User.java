/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/10/2024
 * @Time : 1:08 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.model;

import com.kyaw.bookshoprestapi.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "age", nullable = false)
    private String age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "level", nullable = false)
    private String level;

    private boolean erase;

}
