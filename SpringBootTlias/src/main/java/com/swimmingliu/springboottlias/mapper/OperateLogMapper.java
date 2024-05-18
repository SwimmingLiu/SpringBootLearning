package com.swimmingliu.springboottlias.mapper;

import com.swimmingliu.springboottlias.pojo.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperateLogMapper {
/*
*
operate_user,operate_time,class_name,method_name,method_params,return_value,cost_time
* */

    @Insert("insert operate_log (operate_user,operate_time,class_name,method_name," +
            "method_params,return_value,cost_time) " +
            "values (#{operateUser},#{operateTime},#{className}," +
            "#{methodName},#{methodParams},#{returnValue},#{costTime})")
    public void insertLog(OperateLog operateLog);
}
