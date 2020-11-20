package com.ofg.foreign_teacher_server.service;

import com.ofg.foreign_teacher_server.domain.SysUser;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;

import java.util.Map;

public interface IAuthService {

    //创建用户
    public BaseData<String> createUser(SysUser user);

}
