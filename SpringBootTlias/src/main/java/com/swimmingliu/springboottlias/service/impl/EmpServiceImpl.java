package com.swimmingliu.springboottlias.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.swimmingliu.springboottlias.mapper.EmpMapper;
import com.swimmingliu.springboottlias.pojo.Emp;
import com.swimmingliu.springboottlias.pojo.PageBean;
import com.swimmingliu.springboottlias.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper EmpMapper;

    // 按条件查询员工信息 (分页显示)
    @Override
    public PageBean getEmpByCondition(String name, Short gender,
                                      LocalDate begin, LocalDate end,
                                      Integer page, Integer pageSize) {

        // 设置PageHelper 帮助进行分页显示
        PageHelper.startPage(page, pageSize);
        Page<Emp> p = EmpMapper.getEmpByCondition(name, gender, begin, end);
        PageBean pageBean = new PageBean(p.getTotal(), p.getResult());
        return pageBean;
    }

    // 按照ID号批量删除员工
    @Override
    public void deleteEmpByIds(List<Integer> ids) {
        EmpMapper.deleteEmpByIds(ids);
    }

    // 添加员工信息
    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        EmpMapper.addEmp(emp);
    }

    // 按照ID查询员工信息
    @Override
    public Emp getEmpById(Integer id) {
        Emp emp = EmpMapper.getEmpById(id);
        return emp;
    }

    // 按照ID修改员工信息
    @Override
    public void updateEmpById(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        EmpMapper.updateEmpById(emp);
    }
}
