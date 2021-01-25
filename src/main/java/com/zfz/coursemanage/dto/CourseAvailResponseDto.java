package com.zfz.coursemanage.dto;

import lombok.Data;

@Data
public class CourseAvailResponseDto {
    private String cno;
    private String cname;
    private Integer credit;
    private String cdept;
    private String tname;
}
