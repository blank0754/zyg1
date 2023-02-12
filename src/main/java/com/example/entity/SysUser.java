package com.example.entity;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * 用户实体
 * */
@Data
public class SysUser {
    @NotNull
    private Integer id;
    @NotNull
    private String username;
    @NotNull
    private String password;
}

