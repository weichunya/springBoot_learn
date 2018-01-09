package com.example.service.student.impl;

import com.example.dao.demo.StudentDAO;
import com.example.entity.demo.StudentDTO;
import com.example.service.demo.StudentService;
import com.example.service.student.StudentsServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 01444966 on 2018/1/2.
 */
@Service
public class StudentsServiceClientImpl implements StudentsServiceClient {

    @Autowired
    private StudentService studentService;

    @Override
    public List<StudentDTO> getAllStudentInfo() {
        return studentService.getAllStudentInfo();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return studentService.getStudentById(id);
    }
}
