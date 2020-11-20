package com.ofg.foreign_teacher_server.service.Impl;

import com.ofg.foreign_teacher_server.dao.SysFileMapper;
import com.ofg.foreign_teacher_server.domain.SysFile;
import com.ofg.foreign_teacher_server.domain.ex.BaseData;
import com.ofg.foreign_teacher_server.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Service
public class SysFileService implements ISysFileService {

    @Value("${web.upload-path}")
    private String uploadPath;

    @Autowired
    private SysFileMapper sysFileMapper;

    /**
     * 文件上传
     * @param file
     * @param rep
     * @return
     */
    @Override
    public BaseData<String> upload(MultipartFile file, HttpServletRequest rep) {
        BaseData<String> baseData = new BaseData<String>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/HH-mm-ss/");
        String format = sdf.format(new Date());
        String realPathHead = rep.getSession().getServletContext().getRealPath("/file/");
        File folder = new File(realPathHead + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }


        String oldName = file.getOriginalFilename();
        String suffix = oldName.substring(oldName.lastIndexOf("."));
        String newName = UUID.randomUUID().toString()
                + oldName.substring(oldName.lastIndexOf("."), oldName.length());
        File realPath = new File(folder + newName);

        try {
            file.transferTo(realPath);
            SysFile sysFile = new SysFile();
            sysFile.setCtime(Calendar.getInstance().getTime());
            sysFile.setName(oldName);
            sysFile.setFormat(file.getContentType());
            sysFile.setSuffix(suffix);
            sysFile.setPath("/file/"+new File(format).toString()+newName);
            sysFile.setDelSign(0);

            sysFileMapper.insert(sysFile);

            baseData.setMessage("上传成功");
            baseData.setCode(200);
            baseData.setStatus("success");
            baseData.setResult(sysFile.getId().toString());
        } catch (IOException e) {
            baseData.setMessage(e.getMessage());
            baseData.setCode(500);
        }

        return baseData;
    }
}
