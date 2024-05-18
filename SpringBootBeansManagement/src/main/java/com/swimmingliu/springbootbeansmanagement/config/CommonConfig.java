package com.swimmingliu.springbootbeansmanagement.config;

import com.swimmingliu.springbootbeansmanagement.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.io.SAXReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Slf4j
@Configuration //配置类
public class CommonConfig {

    //声明第三方bean
    @Bean //将当前方法的返回值对象交给IOC容器管理, 成为IOC容器bean
          //通过@Bean注解的name/value属性指定bean名称, 如果未指定, 默认是方法名
    public SAXReader reader(DeptService deptService){
        log.info("AutowiredTest in Params:{}",deptService);
        return new SAXReader();
    }

}
