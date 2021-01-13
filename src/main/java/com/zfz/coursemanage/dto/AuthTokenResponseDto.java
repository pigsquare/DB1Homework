package com.zfz.coursemanage.dto;

import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.entity.T;
import com.zfz.coursemanage.entity.enums.RoleEnum;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AuthTokenResponseDto implements Serializable {
    @NotNull
    @NotBlank
    private String token;

    @NotNull
    private Long expiration;

    @NotNull
    private String name;

    @NotNull
    private String id;

    private RoleEnum role;

    public AuthTokenResponseDto(@NotNull @NotBlank String token, @NotNull Long expiration, @NotNull String name, @NotNull String id,RoleEnum role) {
        this.token = token;
        this.expiration = expiration;
        this.name = name;
        this.id = id;
        this.role=role;
    }
}
