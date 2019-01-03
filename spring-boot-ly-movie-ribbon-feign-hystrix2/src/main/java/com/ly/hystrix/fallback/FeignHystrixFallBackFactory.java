package com.ly.hystrix.fallback;

import org.springframework.stereotype.Component;

import com.ly.feign.MovieControllerInterface;
import com.ly.user.entity.User;
import com.ly.util.result.ResultBean;

import feign.hystrix.FallbackFactory;
/**
 * Hystrix fallbackFactory
 * @author liY
 *
 */
@Component
public class FeignHystrixFallBackFactory implements FallbackFactory<MovieControllerInterface>{

	@Override
	public MovieControllerInterface create(Throwable arg0) {
		// TODO Auto-generated method stub
		return new FeignHystrixFallBack() {
			
			@Override
			public ResultBean selectByPhonePassword(String userPhone, String password) {
				// TODO Auto-generated method stub
				return new ResultBean().put("userPhone", userPhone).put("password", password).put("message", "用户服务已断开连接");
			}

			@Override
			public User selectUserInfoById(Integer id) {
				// TODO Auto-generated method stub
				User user = new User();
				user.setId(id);
				return user;
			}
		};
	}

}
