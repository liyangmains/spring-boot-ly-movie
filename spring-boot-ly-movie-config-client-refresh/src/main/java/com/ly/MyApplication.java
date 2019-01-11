package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@MapperScan(value = {"com.ly.*.dao"})
@RestController
public class MyApplication {
	
	@Value("${name}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
	}
	
	@GetMapping("/port")
	public String getPort(){
		return port;
	}
}
