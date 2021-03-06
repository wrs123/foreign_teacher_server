package com.ofg.foreign_teacher_server.service.Impl;

import com.ofg.foreign_teacher_server.dao.WxAuthcourseMapper;
import com.ofg.foreign_teacher_server.dao.WxCourseMapper;
import com.ofg.foreign_teacher_server.domain.WxAuthcourse;
import com.ofg.foreign_teacher_server.domain.WxCourse;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.service.IAppCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class AppCourseService implements IAppCourseService {

    @Autowired
    private WxCourseMapper wxCourseMapper;

    @Autowired
    private WxAuthcourseMapper authcourseMapper;

    /**
     * 获取课程列表
     * @param type
     * @param areaId
     * @param req
     * @return
     */
    @Override
    public BaseDataResult<Map<Object, Object>> list(Integer type, Long areaId, HttpServletRequest req) {
        BaseDataResult<Map<Object, Object>> list = new BaseDataResult<Map<Object, Object>>();
        String pathUrl = req.getScheme() + "://" + req.getServerName() + ":"
                + req.getServerPort();

        List<Map<Object, Object>> resultList = wxCourseMapper.queryListByType(type);
        List<Map<Object, Object>> newResultList = new ArrayList<Map<Object, Object>>();
        for(Map<Object, Object> r : resultList){
            r.replace("cover", pathUrl + "/ft" + r.get("cover"));
            newResultList.add(r);
        }

        list.setResultList(newResultList);

        return list;
    }

    /**
     * 搜索课程接口
     * @param courseName
     * @param req
     * @return
     */
    @Override
    public BaseData<BaseDataResult<Map<String, Object>>> search(String courseName, HttpServletRequest req) {
        BaseDataResult<Map<String, Object>> list = new BaseDataResult<Map<String, Object>>();
        BaseData<BaseDataResult<Map<String, Object>>> res = new BaseData<BaseDataResult<Map<String, Object>>>();

        try {
            String pathUrl = req.getScheme() + "://" + req.getServerName() + ":"
                    + req.getServerPort();

            List<Map<String, Object>> resultList = wxCourseMapper.queryListByCourseName(courseName);
            List<Map<String, Object>> newResultList = new ArrayList<Map<String, Object>>();
            for(Map<String, Object> r : resultList){
                r.replace("cover", pathUrl + "/ft" + r.get("cover"));
                newResultList.add(r);
            }
            list.setResultList(newResultList);
            res.setResult(list);
            res.setMessage("获取成功");
            res.setCode(200);
            res.setStatus("success");
        }catch (Exception e){
            res.setMessage(e.getMessage());
            res.setMessage(e.getMessage());
            res.setCode(500);
        }




        return res;
    }

    /**
     * 发布课程
     * @param course
     * @return
     */
    @Override
    public BaseData<String> postCourse(WxCourse course) {
        BaseData<String> res = new BaseData<String>();

        WxAuthcourse authcourse = new WxAuthcourse();

        try{
            System.out.println("开始插入课程");
            System.out.println(course.getPhoneNumber());
            course.setDelSign(0);
            wxCourseMapper.insert(course);
//            authcourse.setCourseId(course.getId());
//            authcourse.setUserOpenId(openId);
//            authcourse.setType(0);
//            authcourse.setStatus(0);
//            authcourseMapper.insert(authcourse);

            res.setMessage("上传成功");
            res.setCode(200);
            res.setStatus("success");
            res.setResult(course.getId().toString());

        } catch (Exception e){
            res.setMessage(e.getMessage());
            res.setCode(500);
        }

        return res;
    }

    /**
     * 获取订单列表
     * @param openId
     * @param type
     * @param req
     * @return
     */
    @Override
    public BaseData<BaseDataResult<Map<String, Object>>> orderList(String openId, Integer type, Integer status, HttpServletRequest req) {
        BaseData<BaseDataResult<Map<String, Object>>> res = new BaseData<BaseDataResult<Map<String, Object>>>();
        BaseDataResult<Map<String, Object>> list = new BaseDataResult<Map<String, Object>>();
        type = type == null ? 0 : type;
        Map<String,Object> param = new HashMap<String, Object>();
        String pathUrl = req.getScheme() + "://" + req.getServerName() + ":"
                + req.getServerPort();

        param.put("openId", openId);
        param.put("type", type.toString());
        param.put("status", status);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        try{
            if(type == 1){
                if(status == 999){
                    resultList = authcourseMapper.queryListByUserStatus(param);
                }else{
                    resultList = wxCourseMapper.queryListByUser(param);
                }
            }else if(type == 0){
                resultList = authcourseMapper.queryListByUserTeacher(param);
            }

            List<Map<String, Object>> newResultList = new ArrayList<Map<String, Object>>();
            for(Map<String, Object> r : resultList){
                r.replace("cover", pathUrl + "/ft" + r.get("cover"));
                newResultList.add(r);
            }
            list.setResultList(newResultList);
            res.setMessage("获取成功");
            res.setCode(200);
            res.setStatus("success");
            res.setResult(list);
        }catch (Exception e){
            res.setMessage(e.getMessage());
            res.setCode(500);
        }

        return res;
    }

    /**
     * 获取课程详情
     * @param courseId
     * @return
     */
    @Override
    public BaseData<Map<String, Object>> getCourseDetails(Long courseId) {
        BaseData<Map<String, Object>> res  = new BaseData<Map<String, Object>>();

        try{
            res.setResult(wxCourseMapper.queryById(courseId));
            res.setCode(200);
            res.setStatus("获取成功");
            res.setStatus("success");
        }catch (Exception e){
            res.setMessage(e.getMessage());
            res.setCode(500);
        }

        return res;
    }

    /**
     * 预约课程
     * @param courseId
     * @param openId
     * @return
     */
    @Override
    public BaseData<String> reservationCourse(Long courseId, String openId) {
        BaseData<String> res = new BaseData<String>();
        WxAuthcourse authcourse = new WxAuthcourse();


        try{
            authcourse.setUserOpenId(openId);
            authcourse.setStatus(0);
            authcourse.setType(1);
            authcourse.setCourseId(courseId);
            authcourse.setCtime(Calendar.getInstance().getTime());

            int status = authcourseMapper.insert(authcourse);
            res.setResult("");
            res.setStatus("success");
            res.setCode(200);
            res.setMessage("预约成功");

        }catch (Exception e){
            res.setCode(500);
            res.setStatus("fail");
            res.setMessage(e.getMessage());
        }

        return res;
    }

    @Override
    public BaseData<String> orderDo(WxAuthcourse authcourse) {
        BaseData<String> res = new BaseData<String>();

        try {
            int status = authcourseMapper.updateByCourseId(authcourse);
            res.setResult("");
            res.setStatus("success");
            res.setCode(200);
            res.setMessage("处理成功");
        }catch (Exception e){
            res.setCode(500);
            res.setStatus("fail");
            res.setMessage("处理失败"+e.getMessage());
        }
        return res;
    }
}
