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

    @Override
    public List<C> findByTno() {
        String tno=UserUtil.getCurrentUserAccount();
        return cMapper.findCByTno(tno);
    }

    @Override
    public List<C> findByTno(String tno) {
        return cMapper.findCByTno(tno);
    }

    @Override
    public List<C> findAll() {
        return cMapper.findAll();
    }

    @Override
    public C findByCno(String cno) {
        return cMapper.findCByCno(cno);
    }

    @Override
    public ResponseEntity<Object> updateC(CAddRequestDto requestDto) {
        C c = findByCno(requestDto.getCno());
        String tno = UserUtil.getCurrentUserAccount();
        boolean res;
        if(c.getTno().equals(tno)){
            c.setCredit(requestDto.getCredit());
            c.setCname(requestDto.getCname());
            c.setCdept(requestDto.getCdept());
            res = cMapper.updateC(c);
            return ResponseEntity.ok().body(res);
        }
        return ResponseEntity.badRequest().body(false);
    }

    @Override
    public ResponseEntity<Object> delC(String cno) {
        C c = findByCno(cno);
        String tno = UserUtil.getCurrentUserAccount();
        if(c.getTno().equals(tno)){
            boolean res = cMapper.deleteC(cno);
            return ResponseEntity.ok().body(res);
        }
        return ResponseEntity.badRequest().body("用户错误");
    }
}
