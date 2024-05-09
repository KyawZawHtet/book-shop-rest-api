/**
 * @Author : Kyaw Zaw Htet
 * @Date : 5/9/2024
 * @Time : 7:37 PM
 * @Project_Name : book-shop-rest-api
 */
package com.kyaw.bookshoprestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExitsException extends RuntimeException{

    private String message;

    public EmailAlreadyExitsException(String message) {
        super(message);
    }
}
