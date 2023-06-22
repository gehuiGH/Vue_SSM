package com.dome.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//3.创建Springmvc的配置类，并加载到ioc容器中，
// 加载contorller对应的bean
@Configuration
@ComponentScan("com.dome.contorller")
@EnableWebMvc
public class SpringMvcconfig {

}
