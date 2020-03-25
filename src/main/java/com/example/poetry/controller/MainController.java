package com.example.poetry.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

	@RequestMapping(value="/main",method= RequestMethod.GET)
	public String main(){
		System.out.println("MainController main方法被调用......");
		// 根据Thymeleaf默认模板，将返回resources/templates/main.html
		return "main";
	}

}
