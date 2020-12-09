package com.ofg.foreign_teacher_server.dao;

import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.ExWxCourse;
import org.apache.ibatis.annotations.Param;


import java.util.List;
import java.util.Map;

public interface WxCourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxCourse record);

    WxCourse selectByPrimaryKey(Long id);

    List<WxCourse> selectAll();

    int updateByPrimaryKey(WxCourse record);

    List<Map<Object, Object>> queryListByType(Integer type);

    List<Map<String, Object>> queryListByUser(Map<String, Object> map);

    Map<String, Object> queryById(Long id);

    List<Map<String, Object>> queryListByCourseName(String courseName);




}