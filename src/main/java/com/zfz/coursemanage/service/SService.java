package com.zfz.coursemanage.service;

import com.zfz.coursemanage.entity.S;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SService {
    List<S> findAll();
    ResponseEntity<Object> UpdateS();
}
