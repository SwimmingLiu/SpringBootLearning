package com.swimmingliu.springboottlias.config;

import com.swimmingliu.springboottliasutils.utils.JwtUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {
    @Bean
    public JwtUtils jwtUtils(){
        return new JwtUtils();
    }
}
