package com.swimmingliu.springboottlias.mapper;

import com.swimmingliu.springboottlias.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    // 查询所有部门信息
    @Select("select * from dept")
    public List<Dept> getDept();

    // 删除指定部门
    @Delete("delete from dept where id = #{id}")
    public void deleteDept(Integer id);

    // 添加部门信息
    @Insert("insert into dept(name, create_time, update_time) values (#{name},#{createTime},#{updateTime})")
    public void insertDept(Dept dept);

    // 根据ID查询部门信息
    @Select("select * from dept where id = #{id}")
    public Dept getDeptById(Integer id);

    // 修改指定部门名称
    @Update("update dept set name=#{name}, update_time = #{updateTime} where id = #{id}")
    public void updateDept(Dept dept);
}
