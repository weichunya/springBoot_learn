package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 01444966 on 2018/1/3.
 */
@Controller
public class IndexController {

    @RequestMapping(value = "/")
    String index(){
        return "index";
    }
}
