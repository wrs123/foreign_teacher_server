package com.ofg.foreign_teacher_server.service;

import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;

public interface IAppCourseService {
    public BaseDataResult<WxCourse> query(Integer type);

}
