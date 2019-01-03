package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;


import ribbon.config.RibbonConfig;

@SpringBootApplication
@MapperScan(value={"com.ly.*.dao"})
@EnableEurekaClient
@RibbonClient(value = "movie-controller",configuration = RibbonConfig.class)
public class MyApplication {

	public static void main(String[] args){
		SpringApplication.run(MyApplication.class,args);
	}
}
