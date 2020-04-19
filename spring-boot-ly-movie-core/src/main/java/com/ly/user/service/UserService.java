package com.ly.user.service;

import com.ly.user.entity.User;
import com.ly.util.page.PageBean;

public interface UserService {

	User selectByPhonePassword(String userPhone,String password);
	User selectUserInfoById(Integer id);

	int selectUserCount();
	PageBean<User> userPage(PageBean<User> page);
}
