package com.zfz.coursemanage.service;

import com.zfz.coursemanage.dto.GradeStuRequestDto;
import com.zfz.coursemanage.dto.SCTeacherResponseDto;

import java.util.List;

public interface SCService {
    List<SCTeacherResponseDto> getSCByT(String cno);
    boolean selectC(String cno);
    boolean dropC(String cno);
    boolean gradeStu(GradeStuRequestDto requestDto);
}
