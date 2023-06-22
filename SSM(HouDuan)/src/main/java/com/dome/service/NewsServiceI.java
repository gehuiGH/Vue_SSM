package com.dome.service;

import com.dome.domain.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NewsServiceI {

    public boolean save(News news);
    //删除
    public boolean delete(Integer id);
    public boolean update(News news);
    public boolean getid(Integer id);
    public List<News> getAll();

}
