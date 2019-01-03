package com.ly.user.dao;

import org.apache.ibatis.annotations.Param;

import com.ly.user.entity.User;

/**
 * Dao interface
 */
public interface UserMapper{

	User selectByPhonePassword(@Param("userPhone")String userPhone,@Param("password")String password);
	User selectUserInfoById(Integer id);
}