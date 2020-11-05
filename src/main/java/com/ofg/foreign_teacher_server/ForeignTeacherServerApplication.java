package com.ofg.foreign_teacher_server;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.ofg"})
@ComponentScan(basePackages = {"com.ofg.*","com.ofg.*.controller.*"})
@MapperScan(basePackages="com.ofg.*.dao")
public class ForeignTeacherServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ForeignTeacherServerApplication.class, args);
    }

}
