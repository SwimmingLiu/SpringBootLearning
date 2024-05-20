package com.swimmingliu.springbootbeansmanagement;

import com.swimmingliu.springbootultilsconfiguration.EnableHeaderConfig;
import com.swimmingliu.springbootultilsconfiguration.HeaderConfig;
import com.swimmingliu.springbootultilsconfiguration.MyImportSelector;
import com.swimmingliu.springbootultilsconfiguration.TokenParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

//@ComponentScan({"com.swimmingliu.springbootbeansmanagement","com.swimmingliu.springbootultilsconfiguration"})
//@Import(TokenParser.class)
//@Import(MyImportSelector.class)
@EnableHeaderConfig
@SpringBootApplication
public class SpringBootBeansManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootBeansManagementApplication.class, args);
    }

}
