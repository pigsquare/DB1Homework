package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.dto.AuthTokenRequestDto;
import com.zfz.coursemanage.dto.AuthTokenResponseDto;
import com.zfz.coursemanage.exception.AuthException;
import com.zfz.coursemanage.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthTokenResponseDto> token(
            @RequestBody @Valid AuthTokenRequestDto authTokenRequestDto
            )throws AuthException{
        return ResponseEntity.ok(authService.login(authTokenRequestDto.getUsername()
        ,authTokenRequestDto.getPassword()));
    }
}
