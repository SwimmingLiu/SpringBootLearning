package com.swimmingliu.springboottlias.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Result {
    private Integer code;   // 响应码
    private String msg;     // 响应消息
    private Object data;    // 响应数据

    public static Result success() {
        return new Result(200, "success", null);
    }
    public static Result success(Object data){
        return new Result(200, "success", data);
    }
    public static Result error(){
        return new Result(500, "error", null);
    }
}