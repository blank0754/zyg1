package com.example.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;
@Data
public class useropen {
    @NotNull
    private String equipmentId;
    @NotNull
    private String iphone;
    @NotNull
    private String openTime;
}
