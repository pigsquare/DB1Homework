package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.mapper.SMapper;
import com.zfz.coursemanage.service.SService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sService")
public class SServiceimpl implements SService {

    @Autowired
    private SMapper sMapper;

    @Override
    public List<S> findAll() {
        return sMapper.findAll();
    }
}
