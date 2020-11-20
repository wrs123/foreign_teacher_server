package com.ofg.foreign_teacher_server.dao;

import com.ofg.foreign_teacher_server.domain.SysFile;
import java.util.List;

public interface SysFileMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysFile record);

    SysFile selectByPrimaryKey(Long id);

    List<SysFile> selectAll();

    int updateByPrimaryKey(SysFile record);
}