package com.zfz.coursemanage.service;

import com.zfz.coursemanage.dto.SAddRequestDto;
import com.zfz.coursemanage.entity.S;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SService {
    List<S> findAll();
    S findBySno(String sno);
    ResponseEntity<Object> UpdateS(SAddRequestDto requestDto);
    ResponseEntity<Object> InsertS(SAddRequestDto requestDto);
    boolean deleteBySno(String sno);
}
