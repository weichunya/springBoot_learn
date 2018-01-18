package com.example.service.student;

import com.example.entity.demo.StudentDTO;
import org.springframework.stereotype.Service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

/**
 * Created by 01444966 on 2018/1/2.
 */
@WebService
public interface StudentsServiceClient {

    @WebMethod
    List<StudentDTO> getAllStudentInfo();

    @WebMethod
    StudentDTO getStudentById(Integer id);
}
