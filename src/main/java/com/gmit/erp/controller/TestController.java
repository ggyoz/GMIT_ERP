package com.gmit.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping(value = "/home")
    public String home(){
        return "index.html";
    }

    @ResponseBody
    @RequestMapping("/valueTest")
    public String valueTest(){
        String value = "테스트 String";
        return value;
    }


}
