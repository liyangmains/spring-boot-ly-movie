package com.ly.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class springConfig {

	@ConditionalOnMissingBean
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
