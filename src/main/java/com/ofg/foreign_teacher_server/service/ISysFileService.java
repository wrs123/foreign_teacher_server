package com.ofg.foreign_teacher_server.service;

import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

public interface ISysFileService {

    //文件上传
    BaseData<String> upload(MultipartFile file, HttpServletRequest rep);
}
