package com.swimmingliu.springboottlias.mapper;

import com.github.pagehelper.Page;
import com.swimmingliu.springboottlias.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmpMapper {
    // 按照条件查询员工信息 （分页显示）
    public Page<Emp> getEmpByCondition(String name, Short gender,
                                       LocalDate begin, LocalDate end);

    // 按照ID号批量删除员工
    public void deleteEmpByIds(List<Integer> ids);

    // 添加员工信息
    public void addEmp(Emp emp);

    // 按照ID查询员工信息
    public Emp getEmpById(Integer id);

    public void updateEmpById(Emp emp);
}
