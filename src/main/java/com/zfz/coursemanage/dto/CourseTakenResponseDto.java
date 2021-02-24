package com.zfz.coursemanage.dto;

import lombok.Data;

@Data
public class CourseTakenResponseDto {
    private String cno;
    private String cname;
    private Integer credit;
    private Integer grade;
    private Double point;
}
