package com.zfz.coursemanage.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CAddRequestDto {
    @NotNull
    @NotBlank
    private String cno;

    @NotNull
    @NotBlank
    private String cname;

    @NotNull
    private Integer credit;

    private String cdept;
}
