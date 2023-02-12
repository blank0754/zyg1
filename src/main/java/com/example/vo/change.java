package com.example.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class change {
    @NotNull
    private String username;
    @NotNull
    private String password;
    @NotNull
    private String token;


}
