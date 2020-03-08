package com.ly.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ly.user.entity.User;
import com.ly.util.result.ResultBean;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;

	@GetMapping("/ip")
	public String getIp(HttpServletRequest request){
		String remoteAddr = request.getRemoteAddr();
		String ip = request.getHeader("X-Real_IP");
		return remoteAddr+"=>"+ip;
	}
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
}
