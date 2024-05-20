package com.swimmingliu.springboottlias.mapper;

import com.github.pagehelper.Page;
import com.swimmingliu.springboottlias.anno.Logger;
import com.swimmingliu.springboottliaspojo.pojo.Emp;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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

    
    // 按照ID更新员工信息
    public void updateEmpById(Emp emp);

    // 按照用户名和密码查询员工信息是否正确
    @Select("select * from emp where username=#{username} and password=#{password}")
    public Emp getEmpByUsernameandPassword(Emp emp);

    
    // 按照部门好批量删除员工
    @Delete("delete from emp where dept_id=#{DeptId}")
    public void deleteEmpByDeptId(Integer DeptId);
}
