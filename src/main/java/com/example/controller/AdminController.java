package com.example.controller;

import com.example.service.AdminService;
import com.example.util.QueryInfo;
import com.example.util.Result;
import com.example.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static com.example.util.Jwt.checkToken;

/**
 *管理员控制器
 * */
@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;


    /**
     * 登录接口
     * */
    @PostMapping("/login")
    public Result login(@RequestBody @Validated loginvo loginvo){
        return adminService.login(loginvo);
    }
    /**
     * 修改用户名密码
     * **/
    @PostMapping("/change")
    public Result change(@RequestBody @Validated change change){
        return adminService.change(change);
    }

    /**
     * 授权接口
     * 传入参数：手机号，设备号
     * */
    @PostMapping("/admin/add")
    public Result add(@RequestBody @Validated add add){

        if (checkToken(add.getToken())) {
            return adminService.add(add);
        }else {
            return Result.error("token错误");
        }
    }

    /**
     * 删除接口
     * 传入参数：手机号，设备号
     * */
    @PostMapping("/admin/deleteadd")
    public Result deleteadd(@RequestBody @Validated add add){
        if (checkToken(add.getToken())) {
            return adminService.deleteadd(add);
        }else {
            return Result.error("token错误");
        }
    }


    /**
     * 查询日志接口
     * 传入参数：几页，一页多少数据
     * */
    @PostMapping("/admin/selectall")
    public Result selectall(@RequestBody @Validated QueryInfo queryInfo) throws Exception {
        if (checkToken(queryInfo.getToken())) {
            return adminService.findpage(queryInfo);
        }else {
            return Result.error("token错误");
        }
    }
    /**
     * 查询授权记录接口
     * 传入参数：几页，一页多少数据
     * */
    @PostMapping("/admin/selectadd")
    public Result selectadd(@RequestBody @Validated QueryInfo queryInfo) throws Exception {
        if (checkToken(queryInfo.getToken())) {
            return adminService.userfindpage(queryInfo);
        }else {
            return Result.error("token错误");
        }
    }


    /**
     * 管理员开关,需要设备号
     * */
    @PostMapping("/admin/open")
    public Result adminopen(@RequestBody @Validated open open) throws Exception {
        if (checkToken(open.getToken())) {
            return adminService.adminopen(open);
        }else {
            return Result.error("token错误");
        }
    }

    /**
     * 消毒,需要设备号
     * */
    @PostMapping("/admin/disinfect")
    public Result disinfect(@RequestBody @Validated open open) throws Exception {
        if (checkToken(open.getToken())) {
            return adminService.disinfect(open);
        }else {
            return Result.error("token错误");
        }
    }

    /**
     * 添加设备
     * */
    @PostMapping("/admin/adddevice")
    public Map<String, Object> addDevice(@RequestBody @Validated device device) throws Exception {
        if (checkToken(device.getToken())) {
            return adminService.addDevice(device);
        }else {
            return com.example.util.Map.error("token错误");
        }
    }

    /**
     * 查询设备
     * */
    @PostMapping("/admin/selectdevice")
    public Map<String, Object> selectDevice(@RequestBody @Validated QueryInfo queryInfo) throws Exception {
        if (checkToken(queryInfo.getToken())) {
            return adminService.selectDevice(queryInfo);
        }else {
            return com.example.util.Map.error("token错误");
        }
    }

    /**
     * 删除设备
     * */
    @PostMapping("/admin/deletedevice")
    public Map<String, Object> deleteDevice(@RequestBody @Validated device device) throws Exception {
        if (checkToken(device.getToken())) {
            return adminService.deleteDevice(device);
        }else {
            return com.example.util.Map.error("token错误");
        }
    }
}


