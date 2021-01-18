package com.zfz.coursemanage.service.impl;

import com.zfz.coursemanage.entity.Admin;
import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.entity.T;
import com.zfz.coursemanage.entity.User;
import com.zfz.coursemanage.entity.enums.RoleEnum;
import com.zfz.coursemanage.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user=new User();
        log.info("logging in......");
        List<Admin> admins= userMapper.findAdminByName(s);
        if(!admins.isEmpty()){
            Admin admin=admins.get(0);
            log.info("Admin logged in....");
            user.setName(admin.getName());
            user.setUsername(admin.getId());
            user.setPassword(admin.getPswd());
            user.setRole(RoleEnum.ROLE_A);
            return user;
        }
        List<T> ts=userMapper.findTByName(s);
        if(!ts.isEmpty()){
            T t=ts.get(0);
            user.setUsername(t.getLogn());
            user.setPassword(t.getPswd());
            user.setName(t.getTname());
            user.setRole(RoleEnum.ROLE_T);
            return user;
        }

        List<S> stus =userMapper.findSByName(s);
        if(!stus.isEmpty()){
            S stu=stus.get(0);
            user.setUsername(stu.getLogn());
            user.setPassword(stu.getPswd());
            user.setName(stu.getSname());
            user.setRole(RoleEnum.ROLE_S);
            return user;
        }

        throw new UsernameNotFoundException("用户不存在");
    }
}
