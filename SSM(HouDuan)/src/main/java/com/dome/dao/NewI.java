package com.dome.dao;

import com.dome.domain.News;
import com.dome.domain.user_inf;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface NewI {
    @Insert("insert into news (auther,date,conter) values(#{auther},#{date},#{conter})")
    public void save(News news);
//删除
    @Delete("delete from news where id = #{id}")
    public void delete(Integer id);
    @Update("update news set auther=#{auther},date = #{date},auther=#{auther} where id = #{id}")
    public void update(News news);
    @Select("select * from news where id = #{id}")
    public void getid(Integer id);
    @Select("select * from news")
    public List<News> getAll();

    //
    @Select("select * from news where username = #{username} and password=#{password}")
    List<News> isExist(News news);

}
