package com.zfz.coursemanage.service;

import com.zfz.coursemanage.dto.AdminAddRequestDto;
import com.zfz.coursemanage.dto.AdminChangeRequestDto;
import com.zfz.coursemanage.entity.Admin;
import org.springframework.http.ResponseEntity;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface AdminService {
    ResponseEntity<Object> changeInfo(@NotNull AdminChangeRequestDto changeRequestDto);
    ResponseEntity<Object> newAdmin(@NotNull AdminAddRequestDto addRequestDto);
    List<Admin> findAll();
    boolean deleteById(@NotNull String id);

}
