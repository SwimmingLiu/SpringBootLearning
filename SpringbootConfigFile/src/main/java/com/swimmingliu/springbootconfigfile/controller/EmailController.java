package com.swimmingliu.springbootconfigfile.controller;

import com.swimmingliu.springbootconfigfile.pojo.EmailProperties;
import com.swimmingliu.springbootconfigfile.service.EmailService;
import com.swimmingliu.springbootconfigfile.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
    //注入email配置信息实体类
    @Autowired
    private EmailService emailService;

    //测试方法
    @RequestMapping("/send")
    public Boolean send(){
        //收件人信箱
        String to = "thatdaniel123@outlook.com";
        //邮件标题
        String title = "Test Email";
        //邮件正文
        String content  = "This is a test Email from SpringBoot";
        //发送邮件
        boolean flag = emailService.send(to,title,content);
        return flag;
    }

}
