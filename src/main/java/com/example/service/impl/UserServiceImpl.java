package com.example.service.impl;

//import com.example.entity.SysUser;
import com.example.aliyun.Sample;
import com.example.entity.Sysopen;
import com.example.mapper.SysUserMapper;
import com.example.service.UserService;
import com.example.util.Result;
import com.example.vo.loginvo;
import com.example.vo.open;
import com.example.vo.useropen;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private SysUserMapper userMapper;

    /**
     * 用户开关
     * */
    @Override
    public Result open(useropen open) throws Exception {
        log.info("开启开关");
        Sample sample = new Sample();
        List<Sysopen> array = userMapper.selectopen(open.getEquipmentId(),open.getIphone());
        if(array.size()==0){
            return Result.error("未被授权");
        }
        boolean b = sample.UserOpenApi(open);
        if (b == true) {
            userMapper.useradd(open.getEquipmentId(),open.getIphone(),open.getOpenTime());//添加开关记录
            userMapper.userdelete(open.getEquipmentId(),open.getIphone());//删除授权记录
            return Result.Success("设备开启成功", "");
        } else {
            userMapper.useradd(open.getEquipmentId(),open.getIphone(),open.getOpenTime());
            return Result.fail("设备开启失败请联系管理员");
        }
    }
    }

