package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import ribbon.config.RibbonConfig;

@SpringBootApplication
@MapperScan(value={"com.ly.*.dao"})
@EnableEurekaClient
@EnableCircuitBreaker
@RibbonClient(value = "movie-controller",configuration = RibbonConfig.class)
@EnableFeignClients
public class MyApplication {

	public static void main(String[] args){
		SpringApplication.run(MyApplication.class,args);
	}
}
