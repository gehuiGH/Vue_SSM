package com.dome.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

//4.定义一个servlet容器启动配置类，加载到Spring配置
public class SpringMvcInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
//   配置初始化SpringConfig
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }
//  初始化SpringMvcCofig
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcconfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
//    初始化Springmvc环境


}
