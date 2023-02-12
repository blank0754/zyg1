package com.example.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class loginvo {
    @NotNull
    private String username;
    @NotNull
    private String password;

    private String token;


}
