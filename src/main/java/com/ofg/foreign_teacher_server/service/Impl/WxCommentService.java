package com.ofg.foreign_teacher_server.service.Impl;

import com.ofg.foreign_teacher_server.dao.WxCommentMapper;
import com.ofg.foreign_teacher_server.dao.WxCourseMapper;
import com.ofg.foreign_teacher_server.domain.WxComment;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.domain.ex.ExWxComment;
import com.ofg.foreign_teacher_server.service.IWxCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class WxCommentService implements IWxCommentService {

    @Autowired
    private WxCommentMapper wxCommentMapper;

    @Autowired
    private WxCourseMapper wxCourseMapper;

    @Override
    public BaseData<BaseDataResult<ExWxComment>> query(Long courseId) {
        BaseData<BaseDataResult<ExWxComment>> res = new BaseData<BaseDataResult<ExWxComment>>();
        BaseDataResult<ExWxComment> ress = new BaseDataResult<ExWxComment>();

        try{
            ress.setResultList(wxCommentMapper.queryByCourseId(courseId));
            res.setResult(ress);
            res.setStatus("success");
            res.setCode(200);
            res.setMessage("获取评论列表成功");
        }catch (Exception e){
            res.setMessage(e.getMessage());
            res.setCode(500);
            res.setStatus("fail");
        }

        return res;
    }


    @Override
    public BaseData<String> insert(WxComment wxComment, Long wacId) {

        BaseData<String> result = new BaseData<String>();

        try {
            wxComment.setCtime(Calendar.getInstance().getTime());
            wxComment.setDeleteSign(0);
            wxCommentMapper.insert(wxComment);
            wxCourseMapper.setStatus(wacId);
            result.setResult("");
            result.setStatus("success");
            result.setCode(200);
            result.setMessage("评论成功");

        }catch (Exception e){
            result.setMessage(e.getMessage());
            result.setCode(500);
            result.setStatus("fail");
        }


        return result;
    }

    @Override
    public BaseData<BaseDataResult<ExWxComment>> userComment(String userId) {

        BaseData<BaseDataResult<ExWxComment>> res = new BaseData<BaseDataResult<ExWxComment>>();
        BaseDataResult<ExWxComment> ress = new BaseDataResult<ExWxComment>();

        try {
            ress.setResultList(wxCommentMapper.queryByUserId(userId));
            res.setResult(ress);
            res.setStatus("success");
            res.setCode(200);
            res.setMessage("获取评论列表成功");
        }catch (Exception e){
            res.setMessage(e.getMessage());
            res.setCode(500);
            res.setStatus("fail");
        }

        return res;
    }
}
