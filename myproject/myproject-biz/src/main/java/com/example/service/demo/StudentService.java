package com.example.service.demo;

import com.example.entity.demo.StudentDTO;

import java.util.List;

/**
 * Created by 01444966 on 2017/12/28.
 */
public interface StudentService {

    List<StudentDTO> getAllStudentInfo();

    StudentDTO getStudentById(Integer id);
}
