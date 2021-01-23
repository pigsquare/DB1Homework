package com.zfz.coursemanage.controller;

import com.zfz.coursemanage.dto.TAddRequestDto;
import com.zfz.coursemanage.entity.T;
import com.zfz.coursemanage.service.TService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<Object> addT(@RequestBody TAddRequestDto addRequestDto){
        return tService.insertT(addRequestDto);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> updateT(@RequestBody TAddRequestDto addRequestDto){
        return tService.updateT(addRequestDto);
    }

    @DeleteMapping("/delete/{tno}")
    public ResponseEntity<Object> adleteT(@PathVariable String tno){
        return ResponseEntity.ok(tService.deleteByTno(tno));
    }
}
