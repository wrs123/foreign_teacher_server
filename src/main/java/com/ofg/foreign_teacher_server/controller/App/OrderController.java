package com.ofg.foreign_teacher_server.controller.App;

import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.domain.ex.ExWxCourse;
import com.ofg.foreign_teacher_server.service.IAppCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private IAppCourseService appCourseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseData<BaseDataResult<Map<String, Object>>> list(String openId, Integer type, Integer status, HttpServletRequest req){
        BaseData<BaseDataResult<Map<String, Object>>> res = new BaseData<BaseDataResult<Map<String, Object>>>();

        res = appCourseService.orderList(openId, type, status, req);

        return res;

    }

    @RequestMapping(value = "/orderDo", method = RequestMethod.POST)
    @ResponseBody
    public BaseData<String> orderDo(String courseId, Integer type){

        return appCourseService.orderDo(courseId, type);
    }
}
