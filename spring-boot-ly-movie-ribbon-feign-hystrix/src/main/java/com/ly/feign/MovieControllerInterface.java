package com.ly.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ly.hystrix.fallback.FeignHystrixFallBack;
import com.ly.user.entity.User;
import com.ly.util.result.ResultBean;

@FeignClient(name = "movie-controller",fallback=FeignHystrixFallBack.class)
public interface MovieControllerInterface {

	//方法一:
	@RequestMapping(value = "/user/info",method = RequestMethod.POST)
	ResultBean selectByPhonePassword(@RequestParam("userPhone") String userPhone,@RequestParam("password") String password);
	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	User selectUserInfoById(@PathVariable("id")Integer id);
}
