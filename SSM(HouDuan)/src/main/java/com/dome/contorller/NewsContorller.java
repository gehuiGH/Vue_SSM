package com.dome.contorller;


import com.dome.domain.News;
import com.dome.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
///新闻管理SpringMVC
@CrossOrigin   //允许跨域
@RestController   //一个声明配置注解controller 和 Requestbody响应体注解
@RequestMapping(value = "/news" , produces="text/json;charset=utf-8")
public class NewsContorller {
    @Autowired
    private NewsService newsService;
//    添加新闻信息
    @CrossOrigin    //配置允许跨域
    @PostMapping("/save")
    public String select(@RequestBody News news){
        if(newsService.save(news)){
            System.out.println("新闻信息保存成功!");
            return  "1";
        }else {
            return  "0";
        } }
//查询全部信息
        @GetMapping("/dataAll")
         public String GetAll(){
          return    newsService.getAll().toString();
        }


    @GetMapping("/{id}")
    public String selectByid(@Validated Integer id){
        System.out.println(id);
        return  "selectid";
    }
//修改

//    查询
    @PutMapping()
    String Put(){
        return  "Put";
    }
//    删除
    @DeleteMapping
    String Delete(){
        return "Delete";
    }

}
