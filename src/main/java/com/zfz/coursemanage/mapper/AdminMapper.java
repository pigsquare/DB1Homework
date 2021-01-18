package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminMapper {
    @Select("SELECT * FROM admin")
    List<Admin> findAll();

    @Insert("INSERT INTO admin values(#{id},#{name},#{password})")
    boolean insertAdmin(Admin admin);

    @Update("UPDETE admin SET name=#{name}, password=#{password} WHERE id=#{id}")
    boolean updateById(Admin admin);

    @Delete("DELETE FROM admin WHERE id=#{id}")
    boolean deleteById(String id);
}
