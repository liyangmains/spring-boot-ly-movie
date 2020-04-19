package com.ly.user.service.impl;

import com.ly.user.dao.UserMapper;
import com.ly.user.entity.User;
import com.ly.user.service.UserService;
import com.ly.util.page.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	@Override
	public User selectByPhonePassword(String userPhone,String password) {
		return userMapper.selectByPhonePassword(userPhone,password);
	}

	@Override
	public User selectUserInfoById(Integer id){
		return userMapper.selectUserInfoById(id);
	}

	@Override
	public int selectUserCount() {
		return userMapper.selectUserCount();
	}

	@Override
	public PageBean<User> userPage(PageBean<User> page) {
		int count = userMapper.selectUserCount();
//		boolean haveData = page.setTotalNum((int)(long)count);
//		if(!haveData){
//			return page;
//		}
		if(count == 0){
			page.setPage(null);
			return page;
		}
		Integer limit = page.getPageSize();
		Integer offset = page.getStartOfPage();
		List<User> data = userMapper.selectUserPage(page.getPageSize(),page.getStartOfPage());
		page.setPage(data);
		return page;
	}

}
