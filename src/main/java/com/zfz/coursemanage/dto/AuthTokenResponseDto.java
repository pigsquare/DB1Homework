package com.zfz.coursemanage.dto;

import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.entity.T;
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

    private S s;
    private T t;
}
