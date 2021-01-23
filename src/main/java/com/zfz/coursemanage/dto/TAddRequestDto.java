package com.zfz.coursemanage.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TAddRequestDto {
    @NotNull
    @NotBlank
    private String tno;
    private String tname;
    private String tdept;
    private String tclass;
    @NotNull
    @NotBlank
    private String logn;
    @NotNull
    @NotBlank
    private String pswd;
}
