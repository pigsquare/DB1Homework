package com.zfz.coursemanage.service;

import com.zfz.coursemanage.dto.CAddRequestDto;
import com.zfz.coursemanage.dto.CourseAvailResponseDto;
import com.zfz.coursemanage.dto.CourseTakenResponseDto;
import com.zfz.coursemanage.entity.C;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CService {
    ResponseEntity<Object> addC(CAddRequestDto requestDto);
    List<CourseAvailResponseDto> findAvailC();
    List<CourseAvailResponseDto> findUngradedC();
    List<CourseTakenResponseDto> findGradedC();
    List<C> findByTno();
    List<C> findByTno(String tno);
    List<C> findAll();
    C findByCno(String cno);
    ResponseEntity<Object> updateC(CAddRequestDto requestDto);
    ResponseEntity<Object> delC(String cno);
}
