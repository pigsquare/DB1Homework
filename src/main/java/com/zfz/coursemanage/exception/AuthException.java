package com.zfz.coursemanage.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AuthException extends RuntimeException{
    public AuthException(String message){
        super(message);
    }
}
