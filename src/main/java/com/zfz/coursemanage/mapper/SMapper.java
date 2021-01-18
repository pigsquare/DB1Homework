package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.entity.S;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SMapper {
    List<S> findAll();

    @Select("SELECT * FROM S WHERE sno=#{sno}")
    List<S> findSBySno(String sno);
}
