package com.zfz.coursemanage.mapper;

import com.zfz.coursemanage.dto.CourseAvailResponseDto;
import com.zfz.coursemanage.dto.CourseTakenResponseDto;
import com.zfz.coursemanage.entity.C;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CMapper {
    @Select("SELECT * FROM C")
    List<C> findAll();

    @Select("SELECT * FROM C WHERE cno=#{cno}")
    C findCByCno(String cno);

    @Select("SELECT * FROM C WHERE tno=#{tno}")
    List<C> findCByTno(String Tno);

    boolean insertC(C c);

    List<CourseAvailResponseDto> findAvailC(String sno);

    List<CourseAvailResponseDto> findUngradedC(String sno);

    List<CourseTakenResponseDto> findGradedC(String sno);
}
