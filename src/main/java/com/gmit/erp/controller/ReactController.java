package com.gmit.erp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReactController {

    @GetMapping("/api/hello")
    public String test(){
        return "HELLO, WORLD! ";
    }


}
