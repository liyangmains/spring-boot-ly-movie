package com.ly.user.service;

import com.ly.user.entity.User;

public interface UserService {

	User selectByPhonePassword(String userPhone,String password);
	User selectUserInfoById(Integer id);
}
