package com.swimmingliu.springbootbeansmanagement;

import com.swimmingliu.springbootbeansmanagement.controller.DeptController;
import com.swimmingliu.springbootultilsconfiguration.HeaderGenerator;
import com.swimmingliu.springbootultilsconfiguration.HeaderParser;
import com.swimmingliu.springbootultilsconfiguration.TokenParser;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
class SpringBootBeansManagementApplicationTests {

    @Autowired
    private ApplicationContext applicationContext; //IOC容器对象

    //获取bean对象
    @Test
    public void testGetBean() {
        //根据bean的名称获取
        DeptController deptControllerFromName = (DeptController) applicationContext.getBean("deptController");
        log.info("Bean deptController:{}", deptControllerFromName);
        //根据bean的类型获取
        DeptController deptControllerFromClass = applicationContext.getBean(DeptController.class);
        log.info("Bean deptController:{}", deptControllerFromClass);
        //根据bean的名称 及 类型获取
        DeptController deptController = applicationContext.getBean("deptController", DeptController.class);
        log.info("Bean deptController:{}", deptController);
    }


    //bean的作用域
    @Test
    public void testScope() {
        for (int i = 0; i < 10; i++) {
            DeptController deptController = applicationContext.getBean(DeptController.class);
            System.out.println(deptController);
        }
    }

    @Autowired
    private SAXReader saxReader;

    //第三方bean的管理
    @Test
    public void testThirdBean() throws Exception {
        //SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));
        Element rootElement = document.getRootElement();
        String name = rootElement.element("name").getText();
        String age = rootElement.element("age").getText();

        System.out.println(name + " : " + age);
    }


    @Test
    public void testGetBean2() {
        Object saxReader = applicationContext.getBean("reader");
        System.out.println(saxReader);
    }

    @Test
    public void testTokenParse() {
        System.out.println(applicationContext.getBean(TokenParser.class));
    }

    @Test
    public void testHeaderGenerator() {
        System.out.println(applicationContext.getBean(HeaderParser.class));
    }

}
