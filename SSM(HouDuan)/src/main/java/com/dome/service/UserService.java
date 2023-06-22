package com.dome.service;

import com.dome.dao.UserI;
import com.dome.domain.user_inf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
//  === 业务层 ===
// 对用户信息的增删改查
@Service
public class UserService implements UserServiceI {
    @Autowired(required = false)
    private  UserI useri;
//    添加
    @Override
    public boolean save(user_inf user1) {
        useri.save(user1);
        return true;
    }
//删除
    @Override
    public void delete(Integer id) {
        useri.delete(id);
    }
//修改
    @Override
    public void update(user_inf user1) {
        useri.update(user1);
    }
//完成按照id查询
    @Override
    public void getid(Integer id) {
        useri.getid(id);
    }
//查询所有
    @Override
    public List<user_inf> getAll() {
        return useri.getAll();
    }
//查询用户是否存在
    @Override
    public int isExist(user_inf user) {
        return  useri.isExist(user).size();

    }
}
