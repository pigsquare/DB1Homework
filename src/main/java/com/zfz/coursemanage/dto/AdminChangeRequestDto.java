package com.zfz.coursemanage.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class AdminChangeRequestDto implements Serializable {
    private String name;

    @NotNull
    @NotBlank
    private String password;
}
