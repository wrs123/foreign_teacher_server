package com.ofg.foreign_teacher_server.controller.App;

import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.service.IAppCourseService;
import com.ofg.foreign_teacher_server.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * 课程发布控制器
 * created by ofg on 2020/10/11
 */
@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private ISysFileService sysFileService;

    @Autowired
    private IAppCourseService courseService;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public BaseData<String> upload(@RequestParam("file") MultipartFile file, HttpServletRequest req){
        BaseData<String> baseData = new BaseData<String>();

        if (file.isEmpty()) {
            baseData.setMessage("上传失败，请选择文件");
            baseData.setCode(200);

            return baseData;
        }

        baseData = sysFileService.upload(file, req);

        return baseData;
    }

    @RequestMapping(value = "/course", method = RequestMethod.POST)
    @ResponseBody
    public BaseData<String> post(WxCourse course, @RequestParam("openId")String userId){
        BaseData<String> result = new BaseData<String>();

        result = courseService.postCourse(course, userId);

        return result;
    }
}
