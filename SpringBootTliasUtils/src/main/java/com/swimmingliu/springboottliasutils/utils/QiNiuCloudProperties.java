package com.swimmingliu.springboottliasutils.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "qiniuyun.oss")
public class QiNiuCloudProperties {
    private String accessKey;
    private String secretKey;
    private String bucket;
}
