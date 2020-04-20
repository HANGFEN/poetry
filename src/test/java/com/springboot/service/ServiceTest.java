package com.springboot.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class ServiceTest {

    @Resource
    MailService mailService;

    @Test
    public void sayHelloTest(){
        mailService.sayhello();
    }

    @Test
    public void sendSimplemailTest(){
        mailService.sendSimpleMail("1574024261@qq.com","hello", "hello");
    }
}
