/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/10/2024
 * @Time : 1:18 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.repository;

import com.kyaw.bookshoprestapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
