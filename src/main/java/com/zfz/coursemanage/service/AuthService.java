package com.zfz.coursemanage.service;

import com.zfz.coursemanage.dto.AuthTokenResponseDto;
import com.zfz.coursemanage.exception.AuthException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface AuthService {
    AuthTokenResponseDto login(
            @NotNull @NotBlank String username,
            @NotNull @NotBlank String password
    )throws AuthException;
}
