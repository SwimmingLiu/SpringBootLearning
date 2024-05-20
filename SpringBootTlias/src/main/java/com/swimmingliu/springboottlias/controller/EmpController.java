package com.swimmingliu.springboottlias.controller;

import com.swimmingliu.springboottliaspojo.pojo.Emp;
import com.swimmingliu.springboottliaspojo.pojo.PageBean;
import com.swimmingliu.springboottliaspojo.pojo.Result;
import com.swimmingliu.springboottlias.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService EmpServiceImpl;

    // 1. 按条件查询员工信息
    @GetMapping
    public Result getEmpByCondition(String name, Short gender,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end,
                                    Integer page, Integer pageSize) {
        // 调用业务层方法，按条件查询员工信息 (分页显示)
        log.info("按条件查询员工信息 (分页显示)");
        PageBean pageList = EmpServiceImpl.getEmpByCondition(name, gender, begin, end, page, pageSize);
        return Result.success(pageList);
    }

    // 2. 按照ID号批量删除员工
    @DeleteMapping("/{ids}")
    public Result deleteEmpByIds(@PathVariable List<Integer> ids){
        // 调用业务层方法，按照ID号批量删除员工
        log.info("调用业务层方法，按照ID号批量删除员工");
        EmpServiceImpl.deleteEmpByIds(ids);
        return Result.success();
    }

    // 3. 添加员工信息
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        // 调用业务层方法，添加员工信息
        log.info("调用业务层方法，添加员工信息");
        EmpServiceImpl.addEmp(emp);
        return Result.success();
    }

    // 4. 按照ID查询员工信息
    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable Integer id){
        // 用业务层方法，按照ID查询员工信息
        log.info("用业务层方法，按照ID查询员工信息");
        Emp emp = EmpServiceImpl.getEmpById(id);
        return Result.success(emp);
    }

    // 5. 按照ID修改员工信息
    @PutMapping
    public Result updateEmpById(@RequestBody Emp emp){
        EmpServiceImpl.updateEmpById(emp);
        return Result.success();
    }
}
