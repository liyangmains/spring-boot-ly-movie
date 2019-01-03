package com.ly.user.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ly.feign.MovieControllerInterface;
import com.ly.user.entity.User;
import com.ly.util.result.ResultBean;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@RestController
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private EurekaClient eurekaClient;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	
	@Autowired
	private MovieControllerInterface movieControllerInterface;

	@GetMapping("/login")
	public ResultBean getUserStr(HttpServletRequest request){
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
	@GetMapping("/ribbon")
	public ResultBean getUserInfo(){
		InstanceInfo instanceInfo = eurekaClient.getNextServerFromEureka("MOVIE-CONTROLLER", false);
		String homePageUrl = instanceInfo.getHomePageUrl();
		if(homePageUrl != null){
			
			MultiValueMap<String, Object> postParameters = new LinkedMultiValueMap<>();
			postParameters.add("userPhone", "13246715680");
			postParameters.add("password", "123456");
			System.out.println(homePageUrl);
			return this.restTemplate.postForObject("http://movie-controller/"+"user/info", postParameters, ResultBean.class);
		}
		return new ResultBean().put("code", 10006);
	}
	
	/**
	 * Hystrix默认使用线程池隔离THREAD,并发量较大使用信号量隔离SEMAPHORE
	 * @return
	 */
	@GetMapping("/random")
	@HystrixCommand(fallbackMethod = "getFallBackMethod",commandProperties = @HystrixProperty(name="execution.isolation.strategy",value="SEMAPHORE"))
	public ResultBean getRandom(){
		ServiceInstance instance = loadBalancerClient.choose("movie-controller");
		System.out.println(instance.getPort());
		return new ResultBean().put("port", instance.getPort());
	}
	
	public ResultBean getFallBackMethod(){
		return new ResultBean().put("message", "服务断开连接");
	}
	
	@PostMapping("/user/info")
	public ResultBean getUserInfoByPhonePassword(@RequestParam String userPhone,@RequestParam String password){
		return movieControllerInterface.selectByPhonePassword(userPhone, password);
	}
	@GetMapping("user/{id}")
	public ResultBean getUserInfoById(@PathVariable("id") Integer id){
		User user = movieControllerInterface.selectUserInfoById(id);
		return new ResultBean().put("user", user);
	}
}
