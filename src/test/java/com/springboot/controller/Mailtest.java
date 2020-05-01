package com.springboot.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class Mailtest {

    @Resource
    MailController mailController;

    @Test
    public void mail(){
        mailController.changePassword("1574024261@qq.com","dhf");
        mailController.verifyCode.getCheck();
        mailController.setNewPassword(mailController.verifyCode.getCheck(),"2222");
    }
}
