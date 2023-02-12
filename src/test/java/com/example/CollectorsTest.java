package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsTest {
    public static void groupingByTest(List<String> list){
        Map<Integer,List<String>> s = list.stream().collect(Collectors.groupingBy(String::length));
//        Map<Integer,List<String>> ss = list.stream().collect(Collectors.groupingBy(String::length, Collectors.toList()));
//        Map<Integer, Set<String>> sss = list.stream().collect(Collectors.groupingBy(String::length, HashMap::new,Collectors.toSet()));
        System.out.println(s.toString());
    }
    public static void main(String[] args) {
        List<String> list = Arrays.asList("123","456","789","1101","212121121","asdaa","3e3e3e","2321eew");
        groupingByTest(list);
    }
}
