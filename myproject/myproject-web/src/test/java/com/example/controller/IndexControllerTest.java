package com.example.controller;

import com.example.entity.demo.StudentDTO;
import com.example.service.student.StudentsServiceClient;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by 01444966 on 2018/1/3.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(IndexController.class)
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentsServiceClient studentsServiceClient;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void index() throws Exception {
        StudentDTO st = new StudentDTO();
        st.setName("张三");
        given(this.studentsServiceClient.getStudentById(1)).willReturn(st);
        this.mockMvc.perform(get("/getStudent").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().string("张三"));
    }

}