package com.ofg.foreign_teacher_server.controller.App;

import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.service.IAppCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 课程控制器
 * created by ofg on 2020/10/30
 */
@Controller
@RequestMapping(value = "/app/course")
public class AppCourseController {

    @Autowired
    private IAppCourseService appCourseService;

    /**
     * 获取课程列表
     * @param type
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseDataResult<Map<Object, Object>> list(Integer type, HttpServletRequest req){
        BaseDataResult<Map<Object, Object>> list = new BaseDataResult<Map<Object, Object>>();

        if(type != null){
            list = appCourseService.list(type,null, req);
        }
        return list;
    }

    /**
     * 获取课程详情
     * @param courseId
     * @return
     */
    @RequestMapping(value = "/details", method = RequestMethod.GET)
    @ResponseBody
    public BaseData<Map<String, Object>> details(Long courseId){
        BaseData<Map<String, Object>> result = new BaseData<Map<String, Object>>();

        result = appCourseService.getCourseDetails(courseId);

        return result;
    }

    /**
     * 课程预约
     * @param courseId
     * @param openId
     * @return
     */
    @RequestMapping(value = "/reservation", method = RequestMethod.POST)
    @ResponseBody
    public BaseData<String> details(Long courseId, String openId){
        BaseData<String> result = new BaseData<String>();

        result = appCourseService.reservationCourse(courseId, openId);

        return result;
    }


}
