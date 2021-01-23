package com.zfz.coursemanage.service;

import com.zfz.coursemanage.dto.TAddRequestDto;
import com.zfz.coursemanage.entity.T;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TService {
    List<T> findAll();
    T findByTno(String  tno);
    ResponseEntity<Object> insertT(TAddRequestDto requestDto);
    ResponseEntity<Object> updateT(TAddRequestDto requestDto);
    boolean deleteByTno(String tno);
}
