package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.ly.annotation.RibbonAnnotation;
import com.ly.config.RibbonConfig;

@SpringBootApplication
@MapperScan(value={"com.ly.*.dao"})
@EnableEurekaClient
@RibbonClient(value = "movie-controller",configuration = RibbonConfig.class)
@ComponentScan(excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=RibbonAnnotation.class)})
@EnableFeignClients
public class MyApplication {

	public static void main(String[] args){
		SpringApplication.run(MyApplication.class,args);
	}
}
