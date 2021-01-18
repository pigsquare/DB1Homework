package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.entity.SC;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SCMapper {
    @Select("SELECT * FROM SC")
    List<SC> findAll();

    @Select("SELECT * FROM SC WHERE sno=#{sno}")
    List<SC> findBySno(String sno);

    @Select("SELECT * FROM SC WHERE cno=#{cno}")
    List<SC> findByCno(String cno);
}
