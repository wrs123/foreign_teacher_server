package com.ofg.foreign_teacher_server.service.Impl;

import com.ofg.foreign_teacher_server.dao.SysUserMapper;
import com.ofg.foreign_teacher_server.domain.SysUser;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.service.IAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.util.Calendar;
import java.util.Map;

@Service
public class AuthService implements IAuthService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public BaseData<String> createUser(SysUser user) {
        BaseData<String> res = new BaseData<String>();
        res.setCode(500);
        try{

            user.setCtime(Calendar.getInstance().getTime());

            Integer data = sysUserMapper.insert(user);
            if(data == 1){
                res.setCode(200);
                res.setMessage("注册成功");

                return res;
            }
            res.setMessage("注册失败");


        }catch (Exception e){
            res.setMessage(e.getMessage());
        }

        return res;
    }
}
