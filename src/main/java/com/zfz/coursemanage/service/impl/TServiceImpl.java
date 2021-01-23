package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.TAddRequestDto;
import com.zfz.coursemanage.entity.T;
import com.zfz.coursemanage.mapper.TMapper;
import com.zfz.coursemanage.service.TService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service("tService")
public class TServiceImpl implements TService {
    @Autowired
    TMapper tMapper;
    @Override
    public List<T> findAll() {
        return tMapper.findAll();
    }

    @Override
    public T findByTno(String tno) {
        return tMapper.findByTno(tno);
    }

    @Override
    public ResponseEntity<Object> insertT(TAddRequestDto requestDto) {
        return ResponseEntity.ok(tMapper.insertT(setT(requestDto)));
    }

    @Override
    public ResponseEntity<Object> updateT(TAddRequestDto requestDto) {
        return ResponseEntity.ok(tMapper.updateByTno(setT(requestDto)));
    }

    @Override
    public boolean deleteByTno(String tno) {
        return tMapper.deleteByTno(tno);
    }
    private T setT(TAddRequestDto requestDto){
        T t=new T();
        t.setTno(requestDto.getTno());
        t.setTname(requestDto.getTname());
        t.setTdept(requestDto.getTdept());
        t.setTclass(requestDto.getTclass());
        t.setLogn(requestDto.getLogn());
        t.setPswd(requestDto.getPswd());
        log.info(t.toString());
        return t;
    }
}
