package com.swimmingliu.springboottlias.service.impl;

import com.swimmingliu.springboottlias.mapper.DeptMapper;
import com.swimmingliu.springboottlias.pojo.Dept;
import com.swimmingliu.springboottlias.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper DeptMapper;

    // 获取所有的部门信息
    @Override
    public List<Dept> getDept() {
        List<Dept> deptList = DeptMapper.getDept();
        return deptList;
    }

    // 删除指定部门信息
    @Override
    public void deleteDept(Integer id) {
        DeptMapper.deleteDept(id);
    }

    // 添加部门信息
    @Override
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
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        DeptMapper.updateDept(dept);
    }
}
