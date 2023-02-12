package com.example.util;

import java.util.ArrayList;
import java.util.List;

public class Page {

    public static List subList(List list, int page, int rows)throws Exception{

        List listSort= new ArrayList<>();

        int size=list.size();

        int pageStart=page==1?0:(page-1)*rows;//截取的开始位置

        int pageEnd=size;//截取的结束位置

        if(size>pageStart){

            listSort =list.subList(pageStart, pageEnd);

        }

//总页数

        int totalPage=list.size()/rows;

        return listSort;

    }



}
