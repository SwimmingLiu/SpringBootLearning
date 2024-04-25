package com.swimmingliu.springbootelementexample.controller;

import com.swimmingliu.springbootelementexample.pojo.Emp;
import com.swimmingliu.springbootelementexample.pojo.Result;
import com.swimmingliu.springbootelementexample.service.EmpService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmpController {
//    @Qualifier("empServiceImplementA")
//    @Autowired
//    private EmpServiceImplementA empServiceImplement;

    @Resource(name="empServiceImplementB")
    private EmpService empServiceImplement;

    @RequestMapping("/listEmp")
         public Result list() {
            // 1. 找到xml文件，读取数据
            List<Emp> empList = empServiceImplement.getEmpList();
            // 3. 返回给前端
            return Result.success(empList);
         }
}
