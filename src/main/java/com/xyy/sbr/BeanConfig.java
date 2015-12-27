package com.xyy.sbr;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.xyy.sbr.bean.HashesRunner;
import com.xyy.sbr.bean.ListsRunner;
import com.xyy.sbr.bean.SetsRunner;
import com.xyy.sbr.bean.SortSetsRunner;
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
	
	@Bean
	public ListsRunner schedulerListsRunner(){
		return new ListsRunner();
	}
	
	@Bean
	public SetsRunner schedulerSetsRunner(){
		return new SetsRunner();
	}
	@Bean
	public SortSetsRunner schedulerSortSetsRunner(){
		return new SortSetsRunner();
	}
	

}
