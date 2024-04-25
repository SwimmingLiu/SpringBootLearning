package com.swimmingliu.springbootquickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // Hello方法
    @RequestMapping("/hello")
    public String hello(){
        return "Hello SpringBoot!";
    }
}
