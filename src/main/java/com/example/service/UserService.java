package com.example.service;

import com.example.util.Result;
import com.example.vo.open;
import com.example.vo.useropen;

/**
 * 用户操作接口
 *
 * */
public interface UserService {

     Result open(useropen open) throws Exception;


}
