package com.ly.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ly.feign.FeignInterface;
import com.ly.user.entity.User;
import com.ly.util.result.ResultBean;
import com.ly.util.secret.MD5;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private FeignInterface feignInterface;

	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@GetMapping("/login")
	public ResultBean getUserStr(HttpServletRequest request){
//		request.setAttribute("userPhone", "13246715680");
//		request.setAttribute("password", "123456");
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("MOVIE-CONTROLLER", false);
		String homePageUrl = instanceInfo.getHomePageUrl();
		if(homePageUrl != null){
			
			MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
			postParameters.add("userPhone", "13246715680");
			postParameters.add("password", "123456");
			return this.restTemplate.postForObject(homePageUrl+"user/info", postParameters, ResultBean.class);
		}
		return new ResultBean().put("code", 10006);
	}
	@GetMapping("/user/{id}")
	public ResultBean getUserInfo(@PathVariable Integer id){
		System.out.println(loadBalancerClient.choose("movie-controller").getPort());
		User user = feignInterface.selectUserInfoById(id);
		return new ResultBean().put("userInfo", user);
	}
	@PostMapping("/user/info")
	public ResultBean getUserInfo(User user){
		System.out.println(loadBalancerClient.choose("movie-controller").getPort());
		return feignInterface.selectByPhonePassword(user.getUserPhone(), user.getPassword());
	}
}
