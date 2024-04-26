package com.swimmingliu.springbootmybatisdemo;

import com.swimmingliu.springbootmybatisdemo.mapper.EmpMapper;
import com.swimmingliu.springbootmybatisdemo.mapper.UserMapper;
import com.swimmingliu.springbootmybatisdemo.pojo.Emp;
import com.swimmingliu.springbootmybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Options;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDateTime.now;

@SpringBootTest
class SpringbootMybatisDemoApplicationTests {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EmpMapper empMapper;

    @Test
    public void getAllUser() {
        List<User> userList = userMapper.getUser();
        userList.stream().forEach(user -> {
            System.out.println(user);
        });
    }

    @Test
    // 删除指定员工信息
    public void deleteEmp() {
        Integer id = 21;
        empMapper.deleteEmpById(id);
    }

    @Test
    // 添加员工信息
    public void addEmp() {
        Emp emp = new Emp();
        emp.setUsername("swimmingliu");
        emp.setName("YongjieLiu");
        emp.setImage("swimmingliu.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 1);
        emp.setEntrydate(LocalDate.of(2024, 4, 25));
        emp.setDeptId(1);
        emp.setCreateTime(now());
        emp.setUpdateTime(now());
        empMapper.insertEmp(emp);
        System.out.println(emp.getId());
    }


    @Test
    // 修改员工信息
    public void updateEmp() {
        Emp emp = new Emp();
        emp.setId(23);
        emp.setUsername("SwimmingLiu");
        emp.setName("YongjieLiu");
        emp.setImage("SwimmingLiu.jpg");
        emp.setGender((short) 1);
        emp.setJob((short) 3);
        emp.setEntrydate(LocalDate.of(2024, 4, 25));
        emp.setDeptId(1);
        emp.setUpdateTime(now());
        empMapper.updateEmp(emp);
    }

    @Test
    // 查询员工信息
    public void getEmp() {
        Integer id = 23;
        Emp emp = empMapper.getEmpById(id);
        System.out.println(emp);
    }

    @Test
    // 按条件查询员工信息
    public void getEmpByCondition() {
        String name = "Liu";
        Short gender = (short) 1;
        LocalDate start = LocalDate.of(2023, 4, 25);
        LocalDate end = LocalDate.of(2025, 4, 25);
        List<Emp> empList = empMapper.getEmpByCondition(name, gender, start, end);
        empList.stream().forEach(emp -> {
            System.out.println(emp);
        });
    }

    @Test
    // 动态查询员工信息
    public void getEmpByConditionDymically() {
        String name = "Liu";
        Short gender = (short) 1;
//        LocalDate start = LocalDate.of(2023, 4, 25);
//        LocalDate end = LocalDate.of(2025, 4, 25);
        List<Emp> empList = empMapper.getEmpByConditionDymically(name, gender, null, null);
        empList.stream().forEach(emp -> {
            System.out.println(emp);
        });
    }

    @Test
    // 修改员工信息
    public void updateEmpDynamically() {
        Emp emp = new Emp();
        emp.setId(13);
        emp.setUsername("fangdongbai123");
        emp.setName("方东Bai");
//        emp.setImage("SwimmingLiu.jpg");
        emp.setGender((short) 2);
//        emp.setJob((short) 3);
//        emp.setEntrydate(LocalDate.of(2024, 4, 25));
//        emp.setDeptId(1);
        emp.setUpdateTime(now());
        empMapper.updateEmpDynamically(emp);
    }

    @Test
    // 按ID号批量删除员工信息
    public void deleteEmpByIds(){
        List<Integer> ids = Arrays.asList(11,12);
        empMapper.deleteEmpByIds(ids);
    }
}
