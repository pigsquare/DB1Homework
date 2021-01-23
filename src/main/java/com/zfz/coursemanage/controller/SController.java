package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.dto.ChangePasswordRequestDto;
import com.zfz.coursemanage.dto.SAddRequestDto;
import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/s")
public class SController {
    @Autowired
    private SService sService;

    @RequestMapping("/findall")
    public List<S> findAll(){
        return sService.findAll();
    }

    @PreAuthorize("hasRole('S')")
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @PreAuthorize("hasAnyRole('A')")
    @DeleteMapping("/delete/{sno}")
    public ResponseEntity<Object> deleteS(@PathVariable("sno") String sno){
        return ResponseEntity.ok().body(sService.deleteBySno(sno));
    }

    @PreAuthorize("hasRole('A')")
    @PostMapping("/add")
    public ResponseEntity<Object> addS(@RequestBody SAddRequestDto addRequestDto){
        return ResponseEntity.ok().body(sService.InsertS(addRequestDto));
    }

    @PreAuthorize("hasAnyRole('S','A')")
    @PostMapping("/update")
    public ResponseEntity<Object> updateS(@RequestBody SAddRequestDto addRequestDto){
        return ResponseEntity.ok().body(sService.UpdateS(addRequestDto));
    }

    @GetMapping("/info/{sno}")
    public S getOne(@PathVariable("sno") String sno){
        return sService.findBySno(sno);
    }

    @PreAuthorize("hasRole('S')")
    @PostMapping("/changepassword")
    public ResponseEntity<Object> changePassword(@RequestBody ChangePasswordRequestDto requestDto){
        return sService.changePassword(requestDto);
    }
}
