package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.entity.S;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SMapper {
    List<S> findAll();
}
