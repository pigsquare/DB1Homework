package com.zfz.coursemanage.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class GradeStuRequestDto {
    @NotBlank
    @NotNull
    private String sno;
    @NotBlank
    @NotNull
    private String cno;
    @Max(100)
    @Min(0)
    private Integer score;
}
