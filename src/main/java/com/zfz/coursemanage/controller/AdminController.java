package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.dto.AdminAddRequestDto;
import com.zfz.coursemanage.dto.AdminChangeRequestDto;
import com.zfz.coursemanage.entity.Admin;
import com.zfz.coursemanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @PreAuthorize("hasRole('A')")
    @PostMapping("/change")
    public ResponseEntity<Object> changeInfo(@RequestBody @Valid AdminChangeRequestDto adminChangeRequestDto){
        return adminService.changeInfo(adminChangeRequestDto);
    }

    @PreAuthorize("hasRole('A')")
    @PostMapping("/add")
    public ResponseEntity<Object> addAdmin(@RequestBody @Valid AdminAddRequestDto requestDto){
        return adminService.newAdmin(requestDto);
    }

    @PreAuthorize("hasRole('A')")
    @GetMapping("/list")
    public List<Admin> findAll(){
        return adminService.findAll();
    }

    @PreAuthorize("hasRole('A')")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAdmin(@PathVariable("id")String id){
        adminService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
