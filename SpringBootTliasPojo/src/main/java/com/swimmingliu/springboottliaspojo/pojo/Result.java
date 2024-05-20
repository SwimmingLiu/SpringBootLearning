package com.swimmingliu.springboottliaspojo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Result {
    private Integer code;   // 响应码 1代表成功，0代表失败
    private String msg;     // 响应消息
    private Object data;    // 响应数据

    public static Result success() {
        return new Result(1, "success", null);
    }
    public static Result success(Object data){
        return new Result(1, "success", data);
    }
    public static Result error(){
        return new Result(0, "error", null);
    }
    public static Result error(String msg){
        return new Result(0, msg, null);
    }
}
