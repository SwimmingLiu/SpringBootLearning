package com.swimmingliu.springboottlias.service;

import com.swimmingliu.springboottlias.anno.Logger;
import com.swimmingliu.springboottliaspojo.pojo.Dept;


import java.util.List;

public interface DeptService {
    public List<Dept> getDept();

    public void deleteDept(Integer id) throws Exception;

    public void addDept(Dept dept);

    public Dept getDeptById(Integer id);

    public void updateDept(Dept dept);
}
