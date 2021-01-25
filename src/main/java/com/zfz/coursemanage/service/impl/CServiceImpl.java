package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.CAddRequestDto;
import com.zfz.coursemanage.dto.CourseAvailResponseDto;
import com.zfz.coursemanage.dto.CourseTakenResponseDto;
import com.zfz.coursemanage.entity.C;
import com.zfz.coursemanage.mapper.CMapper;
import com.zfz.coursemanage.service.CService;
import com.zfz.coursemanage.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("cService")
public class CServiceImpl implements CService {
    @Autowired
    private CMapper cMapper;

    @Override
    public ResponseEntity<Object> addC(CAddRequestDto requestDto) {
        C c=new C();
        String tno= UserUtil.getCurrentUserAccount();
        c.setCno(requestDto.getCno());
        c.setCdept(requestDto.getCdept());
        c.setCname(requestDto.getCname());
        c.setCredit(requestDto.getCredit());
        c.setTno(tno);
        return ResponseEntity.ok().body(cMapper.insertC(c));
    }

    @Override
    public List<CourseAvailResponseDto> findAvailC() {
        String sno=UserUtil.getCurrentUserAccount();
        return cMapper.findAvailC(sno);
    }

    @Override
    public List<CourseAvailResponseDto> findUngradedC() {
        String sno=UserUtil.getCurrentUserAccount();
        return cMapper.findUngradedC(sno);
    }

    @Override
    public List<CourseTakenResponseDto> findGradedC() {
        String sno=UserUtil.getCurrentUserAccount();
        return cMapper.findGradedC(sno);
    }
}
