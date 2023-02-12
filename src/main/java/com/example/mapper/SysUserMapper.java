package com.example.mapper;


//import com.example.entity.SysUser;
import com.example.entity.SysUser;
import com.example.entity.Sysopen;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户相关的操作
 * */
public interface SysUserMapper {
    List<SysUser> findAll();

    List<SysUser> Login(@Param("username") String username, @Param("password") String password);

    void change(@Param("username") String username, @Param("password") String password);

    List<Sysopen> selectopen(@Param("equipmentId") String equipmentId, @Param("iphone") String iphone);

    void useradd(String equipmentId, String iphone, String openTime);

    void userdelete(String equipmentId, String iphone);

    void add(String equipmentId, String iphone);

    void deletedevice(String equipmentId);

    Page<Sysopen> findpage();

    List<Sysopen> userfindpage();



}
