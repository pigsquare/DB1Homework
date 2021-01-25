package com.zfz.coursemanage.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CourseSelectRequestDto {
    @NotNull
    @NotBlank
    private String cno;
}
