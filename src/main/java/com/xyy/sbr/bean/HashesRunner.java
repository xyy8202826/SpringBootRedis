package com.xyy.sbr.bean;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

public class HashesRunner implements CommandLineRunner{
	@Autowired
	private StringRedisTemplate template;
	@Override
	public void run(String... args) throws Exception {
		HashOperations<String,String,String> hashOperations= template.opsForHash();
		String key = "spring.boot.redis.test.hashes";
		Map<String,String> map=new HashMap<String,String>();
		map.put("1", "1");
		map.put("2", "2");
		map.put("3", "3");
		if(!this.template.hasKey(key)){
			hashOperations.putAll(key, map);
			System.out.println("add key " + key + ", value=" + map);
		}else{
			System.out.println("Found key " + key + ", value=" + hashOperations.values(key));
		}
	}

}
