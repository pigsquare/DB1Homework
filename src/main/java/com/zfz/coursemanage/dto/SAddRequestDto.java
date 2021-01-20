package com.zfz.coursemanage.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SAddRequestDto {
    @NotNull
    @NotBlank
    private String sno;
    private String sname;
    private String sex;
    private Integer age;
    private String sdept;
    @NotNull
    @NotBlank
    private String logn;
    @NotNull
    @NotBlank
    private String pswd;
}
