package com.swimmingliu.springboottlias.service.impl;

import com.swimmingliu.springboottlias.anno.Logger;
import com.swimmingliu.springboottlias.mapper.DeptMapper;
import com.swimmingliu.springboottlias.mapper.EmpMapper;
import com.swimmingliu.springboottlias.pojo.Dept;
import com.swimmingliu.springboottlias.pojo.Emp;
import com.swimmingliu.springboottlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper DeptMapper;
    @Autowired
    private EmpMapper EmpMapper;

    // 获取所有的部门信息
    @Override
    public List<Dept> getDept() {
        List<Dept> deptList = DeptMapper.getDept();
        return deptList;
    }

    // 删除指定部门信息
    @Transactional(rollbackFor = Exception.class,propagation = Propagation.REQUIRED) // 添加事务，在出错的时候，进行事务回滚
    @Override
    @Logger
    public void deleteDept(Integer id) throws Exception {
        DeptMapper.deleteDept(id);
        EmpMapper.deleteEmpByDeptId(id);
    }

    // 添加部门信息
    @Override
    @Logger
    public void addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        DeptMapper.insertDept(dept);
    }

    // 根据ID查询部门信息
    @Override
    public Dept getDeptById(Integer id) {
        Dept deptInfo = DeptMapper.getDeptById(id);
        return deptInfo;
    }

    // 修改指定部门名称
    @Override
    @Logger
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        DeptMapper.updateDept(dept);
    }
}
