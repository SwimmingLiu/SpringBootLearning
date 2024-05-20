package com.swimmingliu.springboottlias.service;


import com.swimmingliu.springboottlias.anno.Logger;
import com.swimmingliu.springboottliaspojo.pojo.Emp;
import com.swimmingliu.springboottliaspojo.pojo.PageBean;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EmpService {
    public PageBean getEmpByCondition(String name, Short gender,
                                      LocalDate begin, LocalDate end,
                                      Integer page, Integer pageSize);

    public void deleteEmpByIds(List<Integer> ids);

    public void addEmp(Emp emp);

    public Emp getEmpById(Integer id);

    public void updateEmpById(Emp emp);

    public Emp login(Emp emp);
}
