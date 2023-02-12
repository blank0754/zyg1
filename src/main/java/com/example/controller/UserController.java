package com.example.controller;

import com.example.service.UserService;
import com.example.util.Result;
import com.example.vo.loginvo;
import com.example.vo.open;
import com.example.vo.useropen;
import com.sun.org.apache.bcel.internal.classfile.Code;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 用户操作
 * */

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户开关一次，删除权限
     * **/
    @PostMapping("/user/open")
    public Result open(@RequestBody @Validated useropen open) throws Exception {
        return userService.open(open);
    }

}
