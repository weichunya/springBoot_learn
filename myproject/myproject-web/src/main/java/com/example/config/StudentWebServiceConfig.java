package com.example.config;

import com.example.service.student.StudentsServiceClient;
import com.example.service.student.impl.StudentsServiceClientImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import javax.xml.ws.Endpoint;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by 01444966 on 2018/1/18.
 */
@Configuration
public class StudentWebServiceConfig {
    //在测试发布服务的时候，你在浏览器中输入的url地址应该是：http://localhost:8006/test/student?wsdl
    @Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(), "/test/*");
    }

    @Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus() {
        return new SpringBus();
    }

    @Bean
    public StudentsServiceClient studentsServiceClient(){
        return new StudentsServiceClientImpl();
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(springBus(), studentsServiceClient());
        endpoint.publish("/student");
        return endpoint;
    }

}
