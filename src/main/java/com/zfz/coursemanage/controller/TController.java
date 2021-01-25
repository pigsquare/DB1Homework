package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.dto.ChangePasswordRequestDto;
import com.zfz.coursemanage.dto.TAddRequestDto;
import com.zfz.coursemanage.entity.T;
import com.zfz.coursemanage.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/t")
public class TController {
    @Autowired
    private TService tService;

    @RequestMapping("/findall")
    public List<T> findAll(){
        return tService.findAll();
    }

    @GetMapping("/info/{tno}")
    public T findByTno(@PathVariable String tno){
        return tService.findByTno(tno);
    }

    @PreAuthorize("hasRole('A')")
    @PostMapping("/add")
    public ResponseEntity<Object> addT(@RequestBody @Valid TAddRequestDto addRequestDto){
        return tService.insertT(addRequestDto);
    }

    @PreAuthorize("hasAnyRole('A','T')")
    @PostMapping("/update")
    public ResponseEntity<Object> updateT(@RequestBody @Valid TAddRequestDto addRequestDto){
        return tService.updateT(addRequestDto);
    }

    @PreAuthorize("hasRole('A')")
    @DeleteMapping("/delete/{tno}")
    public ResponseEntity<Object> deleteT(@PathVariable String tno){
        return ResponseEntity.ok(tService.deleteByTno(tno));
    }

    @PreAuthorize("hasRole('T')")
    @PostMapping("/changepassword")
    public ResponseEntity<Object> changePassword(@RequestBody @Valid ChangePasswordRequestDto requestDto){
        return tService.changePassword(requestDto);
    }
}
