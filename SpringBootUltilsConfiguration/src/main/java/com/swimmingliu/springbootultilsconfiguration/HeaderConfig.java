package com.swimmingliu.springbootultilsconfiguration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HeaderConfig {
//    @ConditionalOnClass(HeaderParser.class)//存在指定类型的 bean，才会将bean加入IOC容器
//    @ConditionalOnMissingBean(HeaderConfig.class)//不存在指定类型的 bean，才会将bean加入IOC容器

    @Bean
    @ConditionalOnProperty(name ="name",havingValue = "com.swimmingliu")//配置文件中存在指定属性名与值，才会将bean加入IOC容器
    public HeaderParser headerParser(){
        return new HeaderParser();
    }

    @Bean
    public HeaderGenerator headerGenerator(){
        return new HeaderGenerator();
    }
}
