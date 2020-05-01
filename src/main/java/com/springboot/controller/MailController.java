package com.springboot.controller;

import com.springboot.entity.TUser;
import com.springboot.imp.UserImp;
import com.springboot.service.MailService;
import com.springboot.utils.VerifyCode;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class MailController {
    @Autowired
    private UserImp userImp;
    @Autowired
    private MailService mailService;
    public VerifyCode verifyCode = new VerifyCode();
    private TUser persistUser;
    @RequestMapping("/changePassword")
    public String changePassword(@RequestParam("to_") String to_,@RequestParam("username") String username){

        if(to_ != null){
            List<TUser> userList =  userImp.findEmail(to_);
            for (TUser tuser : userList){
                if(tuser.getEmail().equals(to_)){
                    verifyCode.setCheck(mailService.sendSimpleMail(to_));
                    persistUser = tuser;
                }
            }
            //verifyCode.setCheck(mailService.sendSimpleMail(to_));
            //verifyCode.getCheck();
            return "200";
        }
        else{
            return "changePassword";
        }
    }
    @RequestMapping("/setNewPassword")
    public String setNewPassword(@RequestParam("check")String check,@RequestParam("newPassword")String newPassword){
        if(verifyCode.getCheck().equals(check)){
            persistUser.setPassword(newPassword);
            userImp.modifyUser(persistUser);
            return "200";
        }
        else {
            return "setNewPassword";
        }
    }


}