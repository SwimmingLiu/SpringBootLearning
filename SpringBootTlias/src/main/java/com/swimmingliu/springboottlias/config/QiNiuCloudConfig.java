package com.swimmingliu.springboottlias.config;

import com.swimmingliu.springboottliasutils.utils.QiNiuCloudOSS;
import com.swimmingliu.springboottliasutils.utils.QiNiuCloudProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//当前类为Spring配置类
@EnableConfigurationProperties(QiNiuCloudProperties.class)//导入

public class QiNiuCloudConfig {
    @Bean
    public QiNiuCloudOSS qiNiuCloudOSS() {
        return new QiNiuCloudOSS();
    }
}
