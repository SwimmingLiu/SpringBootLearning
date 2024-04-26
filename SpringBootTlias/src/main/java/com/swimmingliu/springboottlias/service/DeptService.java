package com.swimmingliu.springboottlias.service;

import com.swimmingliu.springboottlias.pojo.Dept;

import java.util.List;

public interface DeptService {
    public List<Dept> getDept();

    public void deleteDept(Integer id);

    public void addDept(Dept dept);

    public Dept getDeptById(Integer id);

    public void updateDept(Dept dept);
}
