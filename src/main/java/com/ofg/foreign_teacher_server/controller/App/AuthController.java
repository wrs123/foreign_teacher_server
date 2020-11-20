package com.ofg.foreign_teacher_server.controller.App;

import com.ofg.foreign_teacher_server.domain.SysUser;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.domain.ex.BaseDataResult;
import com.ofg.foreign_teacher_server.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户管理控制器
 * author: ofg
 * 2020.11.10
 */
@Controller
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "/signIn", method = RequestMethod.POST)
    @ResponseBody
    public BaseData<String> signIn(SysUser user){
        BaseData<String> result = new BaseData<String>();

        result = authService.createUser(user);

        return result;
    }

}
