package com.swimmingliu.springbootmybatisdemo.mapper;

import com.swimmingliu.springbootmybatisdemo.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    // EmpMapper: 实现对Emp表增删改查的功能

    // 1. 删除指定员工的信息
    @Delete("delete from emp where id = #{id}")
    public void deleteEmpById(Integer id);

    // 2. 添加员工信息
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public Integer insertEmp(Emp emp);

    // 3. 修改员工信息
    @Update("update emp set username = #{username}, name = #{name}, gender = #{gender}," +
            "image = #{image}, job = #{job}, entrydate = #{entrydate}, " +
            "dept_id = #{deptId}, update_time = #{updateTime} " +
            "where id = #{id}")
    public void updateEmp(Emp emp);

    // 4. 查询员工信息
    // 方案一: 别名
//    @Select("select id, username, password, name, gender, image, job, entrydate, " +
//            "dept_id deptID, create_time createTime, update_time updateTime from emp where id = #{id}")
//    public Emp getEmpById(Integer id);

//    // 方案二: Results和Result注解
//    @Results({
//            @Result(column = "dept_id",property = "deptId"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime"),
//
//    })
//    @Select("select * from emp where id = #{id}")
//    public Emp getEmpById(Integer id);

    // 方案三: 直接yml配置文件 设置 map-underscore-to-camel-case: true
    @Select("select * from emp where id = #{id}")
    public Emp getEmpById(Integer id);

    // 5. 按条件查询员工信息
    @Select("select * from emp where name like concat('%',#{name},'%') and gender = #{gender} " +
            "and entrydate between #{start} and #{end}")

    public List<Emp> getEmpByCondition(String name, Short gender, LocalDate start, LocalDate end);
}
