package com.ly.user.dao;

import com.ly.user.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Dao interface
 */
public interface UserMapper{

	User selectByPhonePassword(@Param("userPhone")String userPhone,@Param("password")String password);
	User selectUserInfoById(Integer id);

	int selectUserCount();
	List<User> selectUserPage(@Param("limit")Integer limit,@Param("offset")Integer offset);

}