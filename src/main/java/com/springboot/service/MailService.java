package com.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    //从properties读取发送者的名字作为邮件的发件人
    @Value("${spring.mail.username}")
    private String from;

    @Autowired()
    private JavaMailSender mailSender;

    public void sayhello(){
        System.out.print("hello");
    }

    public void sendSimpleMail(String to,String subject,
                               String content){
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人
        message.setFrom(from);
        //发送给谁
        message.setTo(to);
        //设置主题
        message.setSubject(subject);
        //设置内容
        message.setText(content);
        mailSender.send(message);
    }
}
