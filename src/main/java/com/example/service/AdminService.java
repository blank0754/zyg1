package com.example.service;

import com.example.util.QueryInfo;
import com.example.util.Result;
import com.example.vo.*;

import java.util.Map;

/**
 * 管理员控制器接口
 *
 * */

public interface AdminService {

    /**
     * 登录接口
     *
     * */
    Result login(loginvo loginvo);

    /**
     * 修改用户名密码
     *
     * */
    Result change(change change);

    /**
     * 授权接口
     *
     * */
    Result add(add add);

    /**
     * 授权接口
     *
     * */
    Result deleteadd(add add);


    /**
     * 分页查询
     * 页码，页数大小，查询条件
     *
     * */
    Result findpage(QueryInfo queryInfo);

    Result userfindpage(QueryInfo queryInfo) throws Exception;

    /**
     * 开关
     * */
    Result adminopen(open open) throws Exception;


    /**
     * 消毒
     * */
    Result disinfect(open open) throws Exception;


    Map<String, Object> addDevice(device device) throws Exception;

    Map<String, Object> selectDevice(QueryInfo queryInfo) throws Exception;

    Map<String, Object> deleteDevice(device device) throws Exception;

}
