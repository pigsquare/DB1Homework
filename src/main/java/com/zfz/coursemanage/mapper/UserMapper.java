package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.entity.Admin;
import com.zfz.coursemanage.entity.C;
import com.zfz.coursemanage.entity.S;
import com.zfz.coursemanage.entity.T;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM S WHERE logn=#{username}")
    List<S> findSByName(String username);

    @Select("SELECT * FROM T WHERE logn=#{username}")
    List<T> findTByName(String username);

    @Select("SELECT * FROM admin WHERE id=#{username}")
    List<Admin> findAdminByName(String username);
}
