package com.ofg.foreign_teacher_server.dao;

import com.ofg.foreign_teacher_server.domain.WxCourse;
import java.util.List;

public interface WxCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxCourse record);

    WxCourse selectByPrimaryKey(Long id);

    List<WxCourse> selectAll();

    List<WxCourse> queryListByType(Integer type);

    int updateByPrimaryKey(WxCourse record);
}