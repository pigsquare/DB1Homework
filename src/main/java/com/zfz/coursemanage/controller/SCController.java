package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.dto.GradeStuRequestDto;
import com.zfz.coursemanage.dto.SCTeacherResponseDto;
import com.zfz.coursemanage.dto.SGradeResponseDto;
import com.zfz.coursemanage.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/sc")
public class SCController {
    @Autowired
    private SCService scService;
    @PreAuthorize("hasRole('T')")
    @GetMapping("/stu/{cno}")
    public List<SCTeacherResponseDto> getFromT(@PathVariable @NotBlank String cno){
        return scService.getSCByT(cno);
    }
    @PostMapping("/grade")
    public boolean gradeStu(@RequestBody @Valid GradeStuRequestDto responseDto){
        return scService.gradeStu(responseDto);
    }
}
