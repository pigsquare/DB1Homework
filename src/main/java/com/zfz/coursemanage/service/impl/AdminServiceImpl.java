package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.AdminAddRequestDto;
import com.zfz.coursemanage.dto.AdminChangeRequestDto;
import com.zfz.coursemanage.service.AdminService;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;

public class AdminServiceImpl implements AdminService {
    @Override
    public ResponseEntity<Object> changeInfo(@NotNull AdminChangeRequestDto changeRequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<Object> newAdmin(@NotNull AdminAddRequestDto addRequestDto) {
        return null;
    }
}
