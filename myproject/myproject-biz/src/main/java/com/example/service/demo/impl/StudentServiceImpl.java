package com.example.service.demo.impl;

import com.example.dao.demo.StudentDAO;
import com.example.entity.demo.StudentDTO;
import com.example.service.demo.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


/**
 * Created by 01444966 on 2017/12/28.
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<StudentDTO> getAllStudentInfo() {
        return studentDAO.getAllStudentInfo();
    }

    @Override
    public StudentDTO getStudentById(Integer id) {
        return studentDAO.getStudentById(id);
    }
}
