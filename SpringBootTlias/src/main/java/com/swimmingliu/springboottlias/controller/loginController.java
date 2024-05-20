package com.swimmingliu.springboottlias.controller;

import com.swimmingliu.springboottliaspojo.pojo.Emp;
import com.swimmingliu.springboottliaspojo.pojo.Result;
import com.swimmingliu.springboottlias.service.EmpService;
import com.swimmingliu.springboottliasutils.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Slf4j

public class loginController {
    @Autowired
    private EmpService empService;
    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("检验登录凭证 账号:{} 密码:{}",emp.getUsername(),emp.getPassword());
        Emp e = empService.login(emp);
        if (e != null){
            HashMap<String, Object> claims = new HashMap<>();
            claims.put("id",e.getId());
            claims.put("name",e.getName());
            claims.put("username",e.getUsername());
            String jwt = jwtUtils.generateJwtToken(claims);
            return Result.success(jwt);
        }
        return Result.error("用户名或密码错误");
    }
}
