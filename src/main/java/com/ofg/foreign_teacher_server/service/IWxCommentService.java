package com.ofg.foreign_teacher_server.service;

import com.ofg.foreign_teacher_server.domain.WxComment;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.domain.ex.ExWxComment;

public interface IWxCommentService {

    public BaseData<BaseDataResult<ExWxComment>> query(Long courseId);

    public BaseData<String> insert(WxComment wxComment);
}
