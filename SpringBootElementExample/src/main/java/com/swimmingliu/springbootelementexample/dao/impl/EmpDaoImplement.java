package com.swimmingliu.springbootelementexample.dao.impl;

import com.swimmingliu.springbootelementexample.dao.EmpDao;
import com.swimmingliu.springbootelementexample.pojo.Emp;
import com.swimmingliu.springbootelementexample.utils.XmlParserUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class EmpDaoImplement implements EmpDao {
    @Override
    public List<Emp> extractXmlData() {
        // 从xml中提取数据
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
