package com.ofg.foreign_teacher_server.dao;

import com.ofg.foreign_teacher_server.domain.WxAuthcourse;
import java.util.List;
import java.util.Map;

public interface WxAuthcourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxAuthcourse record);

    WxAuthcourse selectByPrimaryKey(Long id);

    List<WxAuthcourse> selectAll();

    int updateByPrimaryKey(WxAuthcourse record);

    int updateByCourseId(WxAuthcourse authcourse);

    List<Map<String, Object>> queryListByUserStatus(Map<String, Object> map);

    List<Map<String, Object>> queryListByUserTeacher(Map<String, Object> map);


}