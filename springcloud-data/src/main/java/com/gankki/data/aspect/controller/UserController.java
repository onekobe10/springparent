package com.gankki.data.aspect.controller;

import com.gankki.data.aspect.pojo.User;
import com.gankki.data.aspect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//定义控制器
@Controller
// 定义类请求路径
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService = null;

	// 定义请求
	@RequestMapping("/print")
	// 返回json
	@ResponseBody
	public User printUser(Long id, String userName, String note) {
		User user = new User();
		user.setId(id);
		user.setUsername(userName);
		user.setNote(note);
		userService.printUser(user);
		return user;
	}

	@RequestMapping("/manyAspects")
	public String manyAspects() {
		userService.manyAspects();
		return "manyAspects";
	}

}
