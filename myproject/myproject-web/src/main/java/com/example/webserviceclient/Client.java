package com.example.webserviceclient;

import com.alibaba.fastjson.JSONObject;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

/**
 * Created by 01444966 on 2018/1/18.
 */
public class Client {

    public static void main(String args[]) throws Exception{
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        org.apache.cxf.endpoint.Client client = dcf.createClient("http://localhost:8006/test/student?wsdl");
        //getStudentById 为接口中定义的方法名称  1为传递的参数   返回一个Object对象
        Object objects=client.invoke("getStudentById",1);
        //输出调用结果
        Object jsonStu = JSONObject.toJSON(objects);
        System.out.println("*****"+jsonStu.toString());
        }

        }
