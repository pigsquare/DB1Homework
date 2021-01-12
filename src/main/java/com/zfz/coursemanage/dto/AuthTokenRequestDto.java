package com.zfz.coursemanage.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class AuthTokenRequestDto implements Serializable {
    @NotNull
    @NotBlank
    private String username;

    @NotNull
    @NotBlank
    private String password;
}
