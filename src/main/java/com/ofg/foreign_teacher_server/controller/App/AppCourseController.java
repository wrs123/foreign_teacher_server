package com.ofg.foreign_teacher_server.controller.App;

import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.service.IAppCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 课程控制器
 * created by ofg on 2020/10/30
 */
@Controller
@RequestMapping(value = "/app/course")
public class AppCourseController {

    @Autowired
    private IAppCourseService appCourseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseDataResult<WxCourse> list(Integer type){
        BaseDataResult<WxCourse> list = new BaseDataResult<WxCourse>();

        if(type != null){
            list = appCourseService.query(type);
        }


        return list;
    }

    @RequestMapping(value = "/z", method = RequestMethod.GET)
    @ResponseBody
    public String a(){

        return "33";
    }
}
