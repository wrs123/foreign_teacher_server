package com.ofg.foreign_teacher_server.service.Impl;

import com.ofg.foreign_teacher_server.dao.WxCourseMapper;
import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.service.IAppCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppCourseService implements IAppCourseService {

    @Autowired
    private WxCourseMapper wxCourseMapper;

    @Override
    public BaseDataResult<WxCourse> query(Integer type) {
        BaseDataResult<WxCourse> list = new BaseDataResult<WxCourse>();
        list.setResultList(wxCourseMapper.queryListByType(type));

        return list;
    }
}
