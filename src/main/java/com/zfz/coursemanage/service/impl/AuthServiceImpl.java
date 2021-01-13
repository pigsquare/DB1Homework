package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.AuthTokenResponseDto;
import com.zfz.coursemanage.exception.AuthException;
import com.zfz.coursemanage.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AuthServiceImpl implements AuthService {
    //private final AuthenticationManager authenticationManager;
    //private final
    @Override
    public AuthTokenResponseDto login(@NotNull @NotBlank String username, @NotNull @NotBlank String password) throws AuthException {
        UsernamePasswordAuthenticationToken upToken=new UsernamePasswordAuthenticationToken(username,password);

        return null;
    }
}
