package com.ly;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import com.ly.config.ribbon.RibbonConfig;
import com.ly.config.ribbon.RibbonConfigAnnotaion;



@SpringBootApplication
@MapperScan(value={"com.ly.*.dao"})
@RibbonClient(value = "movie-controller",configuration = RibbonConfig.class)
@ComponentScan(excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=RibbonConfigAnnotaion.class)})
public class MyApplication {

	public static void main(String[] args){
		SpringApplication.run(MyApplication.class,args);
	}
}
