package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.dto.CAddRequestDto;
import com.zfz.coursemanage.dto.CourseAvailResponseDto;
import com.zfz.coursemanage.dto.CourseTakenResponseDto;
import com.zfz.coursemanage.entity.C;
import com.zfz.coursemanage.service.CService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/c")
public class CController {
    @Autowired
    private CService cService;

    @PreAuthorize("hasRole('T')")
    @PostMapping("/add")
    public ResponseEntity<Object> addC(@RequestBody @Valid CAddRequestDto requestDto){
        return cService.addC(requestDto);
    }

    @PreAuthorize("hasRole('S')")
    @GetMapping("/avail")
    public List<CourseAvailResponseDto> findAvailC(){
        return cService.findAvailC();
    }

    @PreAuthorize("hasRole('S')")
    @GetMapping("/ungraded")
    public List<CourseAvailResponseDto> findUngradedC(){
        return cService.findUngradedC();
    }

    @PreAuthorize("hasRole('S')")
    @GetMapping("/graded")
    public List<CourseTakenResponseDto> findGradedC(){
        return cService.findGradedC();
    }

    @PreAuthorize("hasRole('T')")
    @GetMapping("/teach")
    public List<C> getTeachC(){
        return cService.findByTno();
    }

    @GetMapping("/all")
    public List<C> findAll(){
        return cService.findAll();
    }

    @GetMapping("/teacher/{tno}")
    public List<C> findByTno(@PathVariable String tno){
        return cService.findByTno(tno);
    }
}
