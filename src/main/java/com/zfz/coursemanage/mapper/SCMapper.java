package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.dto.CourseAvailResponseDto;
import com.zfz.coursemanage.dto.SCTeacherResponseDto;
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

    @Select("SELECT * FROM SC WHERE sno=#{sno} AND grade IS NULL")
    List<SC> findUngradedCBySno(String sno);

    @Select("SELECT * FROM SC WHERE sno=#{sno} AND grade IS NOT NULL")
    List<SC> findGradedCBySno(String sno);

    boolean selectCourse(SC sc);

    boolean dropCourse(String sno, String cno);

    boolean gradeSC(SC sc);

    List<SCTeacherResponseDto> getSCTeacher(String cno);

    List<CourseAvailResponseDto> getAvailC(String sno);
}
