/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 3:13 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.model;

import com.kyaw.bookshoprestapi.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "admin")
public class Admin{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

    private boolean erase;

}
