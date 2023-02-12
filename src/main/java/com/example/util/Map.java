package com.example.util;


import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Map {
    private String message;//响应的消息
    static HashMap map  = (HashMap) new HashMap();

    public static HashMap error(String message) {
        map.put("message",message);
        map.put("data",null);
        map.put("success",false);

        return map;
    }



}
