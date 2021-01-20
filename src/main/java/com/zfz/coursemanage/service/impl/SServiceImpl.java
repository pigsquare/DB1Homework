package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.SAddRequestDto;
import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.mapper.SMapper;
import com.zfz.coursemanage.service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sService")
public class SServiceImpl implements SService {

    @Autowired
    private SMapper sMapper;

    @Override
    public List<S> findAll() {
        return sMapper.findAll();
    }

    @Override
    public S findBySno(String sno) {
        return sMapper.findSBySno(sno);
    }

    @Override
    public ResponseEntity<Object> UpdateS(SAddRequestDto requestDto) {
        return ResponseEntity.ok().body(sMapper.updateBySno(setS(requestDto)));
    }

    @Override
    public ResponseEntity<Object> InsertS(SAddRequestDto requestDto) {
        return ResponseEntity.ok().body(sMapper.insertS(setS(requestDto)));
    }

    private S setS(SAddRequestDto requestDto) {
        S s=new S();
        s.setAge(requestDto.getAge());
        s.setLogn(requestDto.getLogn());
        s.setPswd(requestDto.getPswd());
        s.setSdept(requestDto.getSdept());
        s.setSex(requestDto.getSex());
        s.setSname(requestDto.getSname());
        s.setSno(requestDto.getSno());
        return s;
    }

    @Override
    public boolean deleteBySno(String sno) {
        return sMapper.deleteBySno(sno);
    }
}
