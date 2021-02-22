package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.ChangePasswordRequestDto;
import com.zfz.coursemanage.dto.SAddRequestDto;
import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.exception.ErrorResult;
import com.zfz.coursemanage.mapper.SMapper;
import com.zfz.coursemanage.service.SService;
import com.zfz.coursemanage.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Override
    public ResponseEntity<Object> changePassword(ChangePasswordRequestDto requestDto) {
        try{
            String sno= UserUtil.getCurrentUserAccount();
            S s=findBySno(sno);
            if(s.getPswd().equals(requestDto.getOldPassword())){
                s.setPswd(requestDto.getNewPassword());
                sMapper.updateBySno(s);
                return ResponseEntity.ok().body("{\"res\": \"password changed\"}");
            }
            return ResponseEntity.badRequest().body("{\"res\": \"password error\"}");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResult(500, "INTERNAL_SERVER_ERROR", "服务器炸了", "/admin/change"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
