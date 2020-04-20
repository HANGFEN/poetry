package com.springboot.controller;

import com.springboot.entity.TUser;
import com.springboot.entity.UserLogin;
import com.springboot.security.SHA1Test;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	@GetMapping("/login")
	public String login(Model model){
		model.addAttribute("userLogin",new UserLogin());
		return "login";
	}
	@PostMapping("/login")
	public String login(@Valid UserLogin user, BindingResult result,
						HttpSession session, Model model) throws NoSuchAlgorithmException {
		if (result.hasErrors()){
			return "redirect:/login";
		}
		//检查用户身份的方法
		//把前台传过来的初始密码转换成数据库加密后的密码
		SHA1Test sha1Test = new SHA1Test();
		user.setPassword(sha1Test.toHexString(user.getPassword()));
		//检查用户身份的方法
		TUser u=userService.checkUser(user);
		if(u!=null){//判断用户是否存在
			session.setAttribute("user",u);//去数据库中检索用户或修改checkUser返回用户对象
			return "main";//主界面
		}
		model.addAttribute("message","账号或密码不正确");
		return "redirect:/login";
	}
	//注册跳转
	@RequestMapping("goregister")
	public String goregister() {
		return "register";
	}
	//注册
	@PostMapping("register")
	public String register(TUser user, Model mv, HttpSession session, String code)throws NoSuchAlgorithmException {
		//检查验证码
		if(!code.equalsIgnoreCase(session.getAttribute("code").toString())) {
			mv.addAttribute("message", "验证码错误！");
			return "register";
		}
		//检查邮箱是否已注册
		if(userService.findEmail(user.getEmail()).size()!=0){
			mv.addAttribute("message","该邮箱已注册账号，请勿重复注册！");

			return "register";
		}
		else {
			//密码加密
			SHA1Test sha1Test = new SHA1Test();
			user.setPassword(sha1Test.toHexString(user.getPassword()));
			//注册时 一律把isAdmin、isVIP、grade设为0
			user.setIsManager(0);
			user.setIsVIP(0);
			user.setGrade(0);
			userService.addUser(user);
			mv.addAttribute("message","注册成功，请登录");
			return "redirect:/login";
		}
	}

	//跳转个人信息管理界面
	@GetMapping("goPersonalInfo")
	public String goPersonalInfo( Model mv, HttpSession session){
		TUser user=(TUser) session.getAttribute("user");
		System.out.println(user.getId());
		mv.addAttribute("user",user);
		mv.addAttribute("sexes",TUser.Sex.toList());
		return "personalInfo";
	}
	//个人信息管理界面中:更改信息后保存
	@PostMapping("SavePersonalInfo")
    public String SavePersonalInfo(Model mv,HttpSession session,TUser user,BindingResult bindingResult) {
		userService.modifyUser(user);
	    mv.addAttribute("message","修改个人信息成功！");
		mv.addAttribute("sexes",TUser.Sex.toList());
		mv.addAttribute("user",user);
        return "personalInfo";
    }

    //找回密码
    @GetMapping("FindPassWord")
	public String find_p(TUser tUser){

		return"";
	}

}
