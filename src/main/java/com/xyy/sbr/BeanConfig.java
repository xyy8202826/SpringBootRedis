package com.xyy.sbr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xyy.sbr.bean.HashesRunner;
import com.xyy.sbr.bean.StartupRunner;

@Configuration
public class BeanConfig {
	@Bean
	public StartupRunner schedulerRunner(){
		return new StartupRunner();
	}
	
	@Bean
	public HashesRunner schedulerHashesRunner(){
		return new HashesRunner();
	}

}
