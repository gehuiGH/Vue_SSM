package com.dome.dao;


import com.dome.domain.user_inf;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;
//持久层
@Service()
public interface UserI {
    @Insert("insert into user_inf (username,password,phone) values(#{username},#{password},#{phone})")
    public void save(user_inf user1);

    @Delete("delete from user_inf where id = #{id}")
    public void delete(Integer id);
    @Update("update user_inf set username=#{username},password = #{password},phone=#{phone} where id = #{id}")
    public void update(user_inf user1);
    @Select("select * from user_inf where id = #{id}")
    public void getid(Integer id);
    @Select("select * from user_inf")
    public List<user_inf> getAll();

//    判断账号密码是否正确
//SELECT COUNT(*) FROM user WHERE user='用户名' AND password=PASSWORD('密码');
//    @Select("select count(*) from user_inf where username=#{username} and password=#{password}")
    @Select("select * from user_inf where username = #{username} and password=#{password}")
    List<user_inf> isExist(user_inf user1);
}
