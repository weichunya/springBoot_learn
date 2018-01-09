package com.example.dao.demo;

import com.example.entity.demo.StudentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by 01444966 on 2017/12/29.
 */
@Mapper
public interface StudentDAO {

    List<StudentDTO> getAllStudentInfo();

    StudentDTO getStudentById(@Param("if") Integer id);
}
