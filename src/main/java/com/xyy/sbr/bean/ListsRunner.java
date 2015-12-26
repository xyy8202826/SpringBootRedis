package com.xyy.sbr.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

public class ListsRunner implements CommandLineRunner{
	@Autowired
	private StringRedisTemplate template;
	@Override
	public void run(String... args) throws Exception {
		ListOperations<String, String> listOperations=template.opsForList();
	}

}
