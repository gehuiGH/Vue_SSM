package com.dome.service;

import com.dome.domain.user_inf;

import java.util.List;
//配置接口
public interface UserServiceI {

//    增加
    public boolean save(user_inf user1);
// 删除
    public void delete(Integer id);
//    修改
    public void update(user_inf user1);
//    查询
    public void getid(Integer id);
//    查询全部
    public List<user_inf> getAll();
//
//判断
//    判断账号密码是否正确
    public int isExist(user_inf user);
}
