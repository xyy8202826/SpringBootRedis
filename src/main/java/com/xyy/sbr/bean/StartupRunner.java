package com.xyy.sbr.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;

public class StartupRunner implements CommandLineRunner{
	@Autowired
	private StringRedisTemplate template;
	@Override
	public void run(String... args) throws Exception {
		System.out.println(template+"=========================================");
	}

}
