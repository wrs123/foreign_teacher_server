package com.ofg.foreign_teacher_server.service;

import com.ofg.foreign_teacher_server.domain.WxAuthcourse;
import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.domain.ex.ExWxCourse;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface IAppCourseService {
    //课程列表接口
    public BaseDataResult<Map<Object, Object>> list(Integer type, Long areaId, HttpServletRequest req);

    //发布课程接口
    public BaseData<String> postCourse(WxCourse course);

    //订单列表接口
    public BaseData<BaseDataResult<Map<String, Object>>> orderList(String openId, Integer type, Integer status, HttpServletRequest req);

    //课程详情接口
    public BaseData<Map<String, Object>> getCourseDetails(Long courseId);

    //课程预约接口
    public BaseData<String> reservationCourse(Long courseId, String openId);

    //教师课程处理
    public BaseData<String> orderDo(WxAuthcourse authcourse);
}
