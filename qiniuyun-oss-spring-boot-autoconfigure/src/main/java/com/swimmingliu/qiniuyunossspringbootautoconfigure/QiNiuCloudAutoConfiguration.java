package com.swimmingliu.qiniuyunossspringbootautoconfigure;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//当前类为Spring配置类
@EnableConfigurationProperties(QiNiuCloudProperties.class)//导入

public class QiNiuCloudAutoConfiguration {
    @Bean
    public QiNiuCloudOSS qiNiuCloudOSS(QiNiuCloudProperties qiNiuCloudProperties) {
        QiNiuCloudOSS qiNiuCloudOSSUltils = new QiNiuCloudOSS();
        qiNiuCloudOSSUltils.setQiNiuCloudProperties(qiNiuCloudProperties);
        return qiNiuCloudOSSUltils;
    }
}
