package com.ly.feign;

import org.springframework.cloud.openfeign.FeignClient;

import com.feign.config.FeignConfig;
import com.ly.user.entity.User;
import com.ly.util.result.ResultBean;

import feign.Param;
import feign.RequestLine;

/**
 * @FeignClient(value = "movie-controller",configuration = FeignConfig.class)
 * configuration = FeignConfig.class
 * 自定义默认feignConfigUration 需用feign自带请求
 * @author Administrator
 *
 */

@FeignClient(name = "movie-controller",configuration = FeignConfig.class)
public interface FeignInterface {

	//方法一:
//	@RequestMapping(value = "/user/info",method = RequestMethod.POST)
//	User selectByPhonePassword(@RequestBody User user);
//	@RequestMapping(value = "/user/info",method = RequestMethod.POST)
//	ResultBean selectByPhonePassword(@RequestParam("userPhone") String userPhone,@RequestParam("password") String password);
//	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
//	User selectUserInfoById(@PathVariable("id")Integer id);
	/**
	 * 自定义需用feign自带默认请求方式RequestLin包括Param
	 * @param userPhone
	 * @param password
	 * @return
	 */
	@RequestLine("POST /user/info")
	ResultBean selectByPhonePassword(@Param("userPhone") String userPhone,@Param("password") String password);
	@RequestLine("GET /user/{id}")
	User selectUserInfoById(@Param("id")Integer id);
}
