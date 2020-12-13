package com.ofg.foreign_teacher_server.dao;

import com.ofg.foreign_teacher_server.domain.WxComment;
import com.ofg.foreign_teacher_server.domain.ex.ExWxComment;

import java.util.List;

public interface WxCommentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(WxComment record);

    WxComment selectByPrimaryKey(Long id);

    List<WxComment> selectAll();

    int updateByPrimaryKey(WxComment record);

    List<ExWxComment> queryByCourseId(Long courseId);

    List<ExWxComment> queryByUserId(String userId);
}