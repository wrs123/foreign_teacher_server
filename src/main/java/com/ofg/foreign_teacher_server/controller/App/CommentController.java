package com.ofg.foreign_teacher_server.controller.App;

import com.ofg.foreign_teacher_server.domain.WxComment;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.domain.ex.ExWxComment;
import com.ofg.foreign_teacher_server.service.IWxCommentService;
import com.ofg.foreign_teacher_server.service.Impl.WxCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 评论控制器
 * author: ofg
 * 2020.11.11
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private IWxCommentService wxCommentService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public BaseData<BaseDataResult<ExWxComment>> list(Long courseId){
        BaseData<BaseDataResult<ExWxComment>> res = new BaseData<BaseDataResult<ExWxComment>>();

        res = wxCommentService.query(courseId);

        return res;
    }

}
