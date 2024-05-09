/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 3:36 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
