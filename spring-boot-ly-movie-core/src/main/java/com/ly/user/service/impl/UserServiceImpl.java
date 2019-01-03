package com.ly.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.user.dao.UserMapper;
import com.ly.user.entity.User;
import com.ly.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User selectByPhonePassword(String userPhone,String password) {
		return userMapper.selectByPhonePassword(userPhone,password);
	}

	
	public User selectUserInfoById(Integer id){
		return userMapper.selectUserInfoById(id);
	}
}
