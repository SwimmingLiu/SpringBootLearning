package com.swimmingliu.springbootelementexample.service.impl;

import com.swimmingliu.springbootelementexample.dao.EmpDao;
import com.swimmingliu.springbootelementexample.pojo.Emp;
import com.swimmingliu.springbootelementexample.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImplementA implements EmpService {

    @Autowired
    private EmpDao empDaoImplement;

    @Override
    public List<Emp> getEmpList () {
        // 获取emp 列表
         List<Emp> empList = empDaoImplement.extractXmlData();
        // 修改性别和职位
        for (Emp emp : empList) {
            String gender = emp.getGender();
            String job = emp.getJob();
            if ("1".equals(gender)){
                emp.setGender("男");
            } else if ("2".equals(gender)){
                emp.setGender("女");
            }
            if ("1".equals(job)){
                emp.setJob("讲师");
            } else if ("2".equals(job)){
                emp.setJob("班主任");
            }else if ("3".equals(job)){
                emp.setJob("就业指导");
            }
        }
        return empList;
    }
}
