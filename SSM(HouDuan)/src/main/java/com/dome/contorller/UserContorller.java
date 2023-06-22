package com.dome.contorller;


import com.dome.domain.user_inf;
import com.dome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


//1.下载坐标
//2. 配置SpringMvc控制器用来处理请求
//表现层
@CrossOrigin
@RestController //rest风格配置器
@RequestMapping(value = "/users")  //根目录
public class UserContorller {
    @Autowired
    private UserService userService;
    @PostMapping
    public String getUserById(@RequestBody user_inf userInf){
        userService.save(userInf);
        System.out.println("save!!!!!");
        return "1";
    }

    @PutMapping
    public String Updateone(@RequestBody user_inf users){
        System.out.println("123");
        return "Updateone";
    }

    @PostMapping("/isexist")
    @CrossOrigin
    public String IsExist(@RequestBody user_inf user) {
        if(userService.isExist(user)>0){
            System.out.println("用户存在");
            return  "1";
        }else {
            System.out.println("用户不存在");
            return "0";
        }

    }
     @PostMapping("/insert")
     @CrossOrigin
     public String saveUser(@RequestBody user_inf user){
        System.out.println("插入成功"+user.toString());
        if(userService.save(user)){
            return  "1";
        }else {
            return  "0";
        }
    }


    @PostMapping("/insertdata")
    public String insertdataone(@RequestBody user_inf userInf){
        if (userService.save(userInf)){
            return "1";

        }else {
            return "0";
        }
    }
}
