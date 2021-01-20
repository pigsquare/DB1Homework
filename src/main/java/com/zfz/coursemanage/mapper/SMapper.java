package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.entity.S;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SMapper {
    List<S> findAll();

    @Select("SELECT * FROM S WHERE sno=#{sno}")
    S findSBySno(String sno);

    @Insert("INSERT INTO s VALUES(#{sno},#{sname},#{sex},#{age},#{sdept},#{logn},#{pswd})")
    boolean insertS(S s);

    boolean updateBySno(S s);

    @Delete("DELETE FROM s WHERE sno=#{sno}")
    boolean deleteBySno(String sno);
}
