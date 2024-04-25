package com.swimmingliu.springbootmybatisdemo.mapper;

import com.swimmingliu.springbootmybatisdemo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {
    @Select("select * from tb_user")
    public List<User> getUser();
}
