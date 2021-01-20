package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.entity.T;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TMapper {
    List<T> findAll();
    T findByTno(String  tno);
    boolean deleteByTno(String tno);
    boolean updateByTno(T t);
    boolean insertT(T t);
}
