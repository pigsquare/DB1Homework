package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.ChangePasswordRequestDto;
import com.zfz.coursemanage.dto.TAddRequestDto;
import com.zfz.coursemanage.entity.T;
import com.zfz.coursemanage.exception.ErrorResult;
import com.zfz.coursemanage.mapper.TMapper;
import com.zfz.coursemanage.service.TService;
import com.zfz.coursemanage.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Override
    public ResponseEntity<Object> changePassword(ChangePasswordRequestDto requestDto) {
        try{
            String tno= UserUtil.getCurrentUserAccount();
            T t=findByTno(tno);
            if(t.getPswd().equals(requestDto.getOldPassword())){
                t.setPswd(requestDto.getNewPassword());
                tMapper.updateByTno(t);
                return ResponseEntity.ok().body("{\"res\": \"password changed\"}");
            }
            return ResponseEntity.badRequest().body("password error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResult(500, "INTERNAL_SERVER_ERROR", "服务器炸了", "/admin/change"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
