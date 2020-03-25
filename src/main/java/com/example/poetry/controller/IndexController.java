package com.example.poetry.controller;

import com.example.poetry.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Controller注解用于指示该类是一个控制器
@Controller
public class IndexController {

	// 映射"/"请求
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String index(Model model){
		System.out.println("IndexController index方法被调用......");
		// 根据Thymeleaf默认模板，将返回resources/templates/index.html
		return "index";
	}

}
