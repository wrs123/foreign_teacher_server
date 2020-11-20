package com.ofg.foreign_teacher_server.dao;

import com.ofg.foreign_teacher_server.domain.WxAuthcourse;
import java.util.List;

public interface WxAuthcourseMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxAuthcourse record);

    WxAuthcourse selectByPrimaryKey(Long id);

    List<WxAuthcourse> selectAll();

    int updateByPrimaryKey(WxAuthcourse record);
}