package com.swimmingliu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    // 实现 Hello 方法
    @RequestMapping("/hello")
    public String hello(){
        return "Hello Spring Boot From Manual Script!";
    }
}
