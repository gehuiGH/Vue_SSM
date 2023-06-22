package com.dome.service;

import com.dome.dao.NewI;
import com.dome.domain.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NewsService implements NewsServiceI {
    @Autowired(required = false)
    private NewI newI;
    @Override
    public boolean save(News news) {
        newI.save(news);
        return  true;
    }

    @Override
    public boolean delete(Integer id) {
        newI.delete(id);
        return  true;
    }

    @Override
    public boolean update(News news) {
        newI.update(news);
        return  true;
    }

    @Override
    public boolean getid(Integer id) {
        newI.getid(id);
        return  true;
    }

    @Override
    public List<News> getAll() {
        return newI.getAll();
    }




}
