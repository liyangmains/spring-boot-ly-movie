package com.ly.config.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
@RibbonConfigAnnotaion //自定义注解
public class RibbonConfig {

	@Autowired
	private IClientConfig iClientConfig;
	@Bean
	public IRule ribbonRule(IClientConfig iClientConfig) {
		return new RandomRule();
	}
}
