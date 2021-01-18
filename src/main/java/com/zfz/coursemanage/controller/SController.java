package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/s")
public class SController {
    @Autowired
    private SService sService;

    @RequestMapping("/findAll")
    public List<S> findAll(){
        return sService.findAll();
    }

    @PreAuthorize("hasRole('S')")
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
}
