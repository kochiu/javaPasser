package com.sztx.javaPasser.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sztx.javaPasser.web.config.LoginConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sztx.javaPasser.dataaccess.domain.UserDO;
import com.sztx.se.web.controller.BaseController;

@Controller
public class LoginController extends BaseController {
	
	@Autowired
	private LoginConfig loginConfig;
	
	@RequestMapping(value = "/")
	public String root(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "redirect:/index";
	}

	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
		String username = "zhangsan";
		UserDO user = new UserDO();
		user.setId(12);
		user.setUsername(username);
		user.setNick("张三");
		user.setPassword("abc123456");
		model.addAttribute("demo", true);
		model.addAttribute("user", user);
		return "/index";
	}
	
}
