package com.swimmingliu.springboottlias.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
