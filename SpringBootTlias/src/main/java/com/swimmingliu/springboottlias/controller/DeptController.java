package com.swimmingliu.springboottlias.controller;

import com.swimmingliu.springboottliaspojo.pojo.Dept;
import com.swimmingliu.springboottliaspojo.pojo.Result;
import com.swimmingliu.springboottlias.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService DeptServiceImpl;

    // 查询所有部门信息
    @GetMapping
    public Result getDept(){
        // 调用业务逻辑层，获取部门信息
        log.info("调用业务逻辑层，获取部门信息");
        List<Dept> deptList = DeptServiceImpl.getDept();
        return Result.success(deptList);
    }

    // 删除指定部门
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id) throws Exception {
        // 调用业务逻辑层，删除指定部门
        log.info("调用业务逻辑层，删除指定部门");
        DeptServiceImpl.deleteDept(id);
        return Result.success();
    }

    // 添加部门信息
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        // 调用业务逻辑层，添加部门信息
        log.info("调用业务逻辑层，添加部门信息");
        DeptServiceImpl.addDept(dept);
        return Result.success();
    }

    // 根据ID查询部门信息
    @GetMapping("/{id}")
    public Result getDeptById(@PathVariable Integer id){
        // 调用业务逻辑层，根据ID查询部门信息
        log.info("调用业务逻辑层，根据ID查询部门信息");
        Dept deptInfo = DeptServiceImpl.getDeptById(id);
        return Result.success(deptInfo);
    }

    // 根据ID修改指定部门名称
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        // 调用业务逻辑层，修改指定部门名称
        log.info("调用业务逻辑层，修改指定部门名称");
        DeptServiceImpl.updateDept(dept);
        return Result.success();
    }

    //
}
