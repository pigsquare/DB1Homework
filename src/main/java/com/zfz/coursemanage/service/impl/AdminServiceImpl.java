package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.dto.AdminAddRequestDto;
import com.zfz.coursemanage.dto.AdminChangeRequestDto;
import com.zfz.coursemanage.dto.ChangePasswordRequestDto;
import com.zfz.coursemanage.entity.Admin;
import com.zfz.coursemanage.exception.ErrorResult;
import com.zfz.coursemanage.mapper.AdminMapper;
import com.zfz.coursemanage.service.AdminService;
import com.zfz.coursemanage.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public ResponseEntity<Object> changeInfo(@NotNull AdminChangeRequestDto changeRequestDto) {
        try{
            String userId= UserUtil.getCurrentUserAccount();
            Admin admin=new Admin();
            admin.setId(userId);
            admin.setName(changeRequestDto.getName());
            admin.setPassword(changeRequestDto.getPassword());
            adminMapper.updateById(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResult(500, "INTERNAL_SERVER_ERROR", "服务器炸了", "/admin/change"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> newAdmin(@NotNull AdminAddRequestDto addRequestDto) {
        try{
            Admin admin=new Admin();
            admin.setId(addRequestDto.getId());
            admin.setName(addRequestDto.getName());
            admin.setPassword(addRequestDto.getPassword());
            adminMapper.insertAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResult(500, "INTERNAL_SERVER_ERROR", "服务器炸了", "/admin/change"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public List<Admin> findAll() {
        return adminMapper.findAll();
    }

    @Override
    public boolean deleteById(@NotNull String id) {
        return adminMapper.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> changePassword(ChangePasswordRequestDto requestDto) {
        try{
            String id= UserUtil.getCurrentUserAccount();
            //T t=findByTno(tno);
            Admin t=adminMapper.findById(id);
            if(t.getPassword().equals(requestDto.getOldPassword())){
                t.setPassword(requestDto.getNewPassword());
                adminMapper.updateById(t);
                return ResponseEntity.ok().body("password changed");
            }
            return ResponseEntity.badRequest().body("password error");
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResult(500, "INTERNAL_SERVER_ERROR", "服务器炸了", "/admin/change"),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
