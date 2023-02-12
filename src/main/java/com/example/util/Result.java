package com.example.util;

import lombok.Data;

@Data
public class Result {

    /**
     * 响应给前端是否成功的标识
     *
     * */
    private boolean Success;//是否成功

    private String message;//响应的消息

    private Object data;//响应数据


    public Result() {
    }

    public Result(boolean Success, String message, Object data) {
        this.Success = Success;
        this.message = message;
        this.data = data;
    }

    public Result(boolean Success, String message) {
        this.Success = Success;
        this.message = message;
    }

    //响应成功的结果
    public static Result Success(String message,Object data){
        return new Result(true,message,data);
    }
    //响应失败的结果
    public static Result fail(String message){
        return new Result(false,message);
    }

    public static Result error(String message) {
        return new Result(false,message);
    }
}
