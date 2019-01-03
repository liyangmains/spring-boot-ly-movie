package com.ly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Contract;
import feign.Logger;

@Configuration
public class FeignConfig {

	@Bean
	public Contract feignContract(){
		return new feign.Contract.Default();
	}
	
	@Bean
	Logger.Level getLogger(){
		return Logger.Level.FULL;
	}
}
