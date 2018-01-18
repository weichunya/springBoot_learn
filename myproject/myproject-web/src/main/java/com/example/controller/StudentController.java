package com.example.controller;

import com.example.service.student.StudentsServiceClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * Created by 01444966 on 2017/12/24.
 */
@RestController
@RequestMapping(value = "/")
public class StudentController {

    @Resource
    private StudentsServiceClient studentServiceClient;

    @RequestMapping(value = "/students")
    public Object  home(){
        return studentServiceClient.getAllStudentInfo();
    }

    @RequestMapping(value = "/getStudent")
    public Object  getStudent(){
        return studentServiceClient.getStudentById(1);
    }
    @RequestMapping(value = "/errortest")
    public String testError() throws Exception{
        throw new Exception("发生错误");
    }
}
