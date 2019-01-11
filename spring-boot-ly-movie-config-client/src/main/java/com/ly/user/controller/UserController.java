package com.ly.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ly.user.dto.UserDto;
import com.ly.user.entity.User;
import com.ly.user.service.UserService;
import com.ly.util.result.ResultBean;
import com.ly.util.secret.MD5;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/user/info")
	public ResultBean getUser(@ModelAttribute UserDto userdto){
		String password = MD5.MD5encryption(userdto.getPassword());
		User user = userService.selectByPhonePassword(userdto.getUserPhone(), password);
		return new ResultBean().put("userInfo", user);
	}
	@GetMapping("/user/{id}")
	public User getUserInfo(@PathVariable Integer id){
		User user = userService.selectUserInfoById(id);
		return user;
	}
}
