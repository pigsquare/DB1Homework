package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.GradeStuRequestDto;
import com.zfz.coursemanage.dto.SCTeacherResponseDto;
import com.zfz.coursemanage.entity.C;
import com.zfz.coursemanage.entity.SC;
import com.zfz.coursemanage.mapper.CMapper;
import com.zfz.coursemanage.mapper.SCMapper;
import com.zfz.coursemanage.service.SCService;
import com.zfz.coursemanage.util.PointUtil;
import com.zfz.coursemanage.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scService")
public class SCServiceImpl implements SCService {
    @Autowired
    private SCMapper scMapper;
    @Autowired
    private CMapper cMapper;
    @Override
    public List<SCTeacherResponseDto> getSCByT(String cno) {
        // String tno= UserUtil.getCurrentUserAccount();
        return scMapper.getSCTeacher(cno);
    }

    @Override
    public boolean selectC(String cno) {
        String sno = UserUtil.getCurrentUserAccount();
        SC sc = new SC();
        sc.setSno(sno);
        sc.setCno(cno);
        return scMapper.selectCourse(sc);
    }

    @Override
    public boolean dropC(String cno) {
        String sno = UserUtil.getCurrentUserAccount();
        SC sc = new SC();
        sc.setSno(sno);
        sc.setCno(cno);
        return scMapper.dropCourse(sc);
    }

    @Override
    public boolean gradeStu(GradeStuRequestDto requestDto) {
        String tno = UserUtil.getCurrentUserAccount();
        C c = cMapper.findCByCno(requestDto.getCno());
        if(c.getTno().equals(tno)){
            SC sc = new SC();
            sc.setCno(requestDto.getCno());
            sc.setSno(requestDto.getSno());
            sc.setGrade(requestDto.getScore());
            sc.setPoint(PointUtil.getPoint(requestDto.getScore()));
            return scMapper.gradeSC(sc);
        }
        return false;
    }
}
