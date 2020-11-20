package com.ofg.foreign_teacher_server.service;

import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.domain.ex.ExWxCourse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IAppCourseService {
    public BaseDataResult<Map<Object, Object>> list(Integer type, Long areaId, HttpServletRequest req);

    public BaseData<String> postCourse(WxCourse course, String openId);

    public BaseData<BaseDataResult<Map<String, Object>>> orderList(String openId, Integer type, HttpServletRequest req);

    public BaseData<Map<String, Object>> getCourseDetails(Long courseId);
}
