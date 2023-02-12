package com.example.vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
public class device {

    @NotNull
    private String equipmentId;
    @NotNull
    private String token;


}
