package com.example.service.student;

import com.example.entity.demo.StudentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 01444966 on 2018/1/2.
 */
public interface StudentsServiceClient {
    List<StudentDTO> getAllStudentInfo();

    StudentDTO getStudentById(Integer id);
}
