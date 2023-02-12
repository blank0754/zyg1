package com.example.entity;

import lombok.Data;

import java.util.List;

@Data
public class Person {
    private String equipmentId;
    private List<String> iphone;

    public Person(String key, List<String> value) {
        this.equipmentId = key;
        this.iphone = value;
    }
}
