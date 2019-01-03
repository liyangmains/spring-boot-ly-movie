package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = {"com.ly.*.dao"})
public class MyApplication {

	public static void main(String[] args){
		//123admin提交
		SpringApplication.run(MyApplication.class, args);
	}
}