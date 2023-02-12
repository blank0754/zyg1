package com.example.service.impl;

//import com.example.entity.SysUser;
import com.alibaba.fastjson.JSONObject;
import com.aliyun.tea.TeaModel;
import com.example.aliyun.Sample;
import com.example.entity.Person;
import com.example.entity.SysUser;
import com.example.entity.Sysopen;
import com.example.mapper.SysUserMapper;
import com.example.service.AdminService;
import com.example.service.UserService;
import com.example.util.Jwt;
import com.example.util.QueryInfo;
import com.example.util.Result;
import com.example.vo.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.util.Page.subList;
import static com.example.util.PageResult.pageResult;

@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    private SysUserMapper userMapper;


    @Override
    public Result login(loginvo loginvo) {
        log.info("开始登录");
        List<SysUser> array = userMapper.Login(loginvo.getUsername(), loginvo.getPassword());
        if (array.size() == 0) {
            return Result.fail("账号或密码错误");
        } else {
            //添加token
            loginvo.setToken(Jwt.createToken());
            return Result.Success("登录成功", loginvo);

        }
    }

    @Override
    public Result change(change change) {
        log.info("开始修改");
        userMapper.change(change.getUsername(), change.getPassword());
        return Result.Success("修改成功","");

    }

    @Override
    public Result add(add add) {
        log.info("开始授权");
        List<Sysopen> array = userMapper.selectopen(add.getEquipmentId(),add.getIphone());
        if(array.size()==0){
            userMapper.add(add.getEquipmentId(),add.getIphone());
            return Result.Success("授权成功","");
        }else {
            return Result.fail("账号已存在");
        }
    }

    @Override
    public Result deleteadd(add add) {
        log.info("开始删除");
        userMapper.userdelete(add.getEquipmentId(),add.getIphone());//删除授权记录

        return Result.Success("删除成功","");

    }

    @Override
    public Result findpage(QueryInfo queryInfo) {
        log.info("开始数据分页");
        System.out.println(queryInfo.getPageNumber());
        System.out.println(queryInfo.getPageSize());
        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
        Page<Sysopen> findpage = userMapper.findpage();
        long total = findpage.getTotal();
        List<Sysopen> list = findpage.getResult();
        log.info("总数据条数"+total);
        log.info("分页结果"+list);
        return pageResult(total, list);
    }
    @Override
    public Result userfindpage(QueryInfo queryInfo) throws Exception {
//        log.info("开始数据分页");
//        System.out.println(queryInfo.getPageNumber());
//        System.out.println(queryInfo.getPageSize());
//        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
//        Page<Sysopen> findpage = userMapper.userfindpage();
        List<Sysopen> list = userMapper.userfindpage();

        Map<String,List<String>> map = list.stream().collect(Collectors.groupingBy(Sysopen::getEquipmentId,Collectors.mapping(Sysopen::getIphone,Collectors.toList())));
        List<Person> list1 = map.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .map(e -> new Person(e.getKey(), e.getValue())).collect(Collectors.toList());


        //创建Page类
        Page page = new Page(queryInfo.getPageNumber(),queryInfo.getPageSize());
        //为Page类中的total属性赋值
        int total = list1.size();
        page.setTotal(total);
        //计算当前需要显示的数据下标起始值
        int startIndex = (queryInfo.getPageNumber() - 1) * queryInfo.getPageSize();
        int endIndex = Math.min(startIndex + queryInfo.getPageSize(),total);
        //从链表中截取需要显示的子链表，并加入到Page
        page.addAll(list1.subList(startIndex,endIndex));
        //以Page创建PageInfo
        PageInfo pageInfo = new PageInfo<>(page);


//
//        PageHelper.startPage(queryInfo.getPageNumber(),queryInfo.getPageSize());
//        PageInfo<Map<String, String>> pageInfo = new PageInfo(list1);
//        List list2 = subList(list1, queryInfo.getPageNumber(), queryInfo.getPageSize());

        System.out.println(pageInfo);
        return pageResult(total, pageInfo.getList());


//        log.info("总数据条数"+total);
//        log.info("分页结果"+list);
//        return Result.Success("",pageInfo);
    }

    @Override
    public Result adminopen(open open) throws Exception {
        log.info("管理员开启开关");
        Sample sample = new Sample();
        boolean b = sample.OpenApi(open);
        if (b == true) {
            return Result.Success("设备开启成功", "");
        } else {
            return Result.fail("设备开启失败请上电后重试");
        }
    }

    @Override
    public Result disinfect(open open) throws Exception {
        log.info("管理员开启消毒");
        Sample sample = new Sample();
        boolean b = sample.disinfectApi(open);
        if (b == true) {
            return Result.Success("设备开启成功", "");
        } else {
            return Result.fail("设备开启失败请上电后重试");
        }
    }

    @Override
    public Map<String, Object> addDevice(device device) throws Exception {
        Sample sample = new Sample();
        return sample.addDeviceApi(device);
    }

    @Override
    public Map<String, Object> selectDevice(QueryInfo queryInfo) throws Exception {
        Sample sample = new Sample();
        return sample.selectDeviceApi(queryInfo);
    }

    @Override
    public Map<String, Object> deleteDevice(device device) throws Exception {
        Sample sample = new Sample();
        userMapper.deletedevice(device.getEquipmentId());
        return sample.deleteDeviceApi(device);
    }






}
