package com.xyy.sbr.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;

import com.xyy.sbr.util.ListUtil;

public class SortSetsRunner implements CommandLineRunner{
	@Autowired
	private StringRedisTemplate template;
	@Override
	public void run(String... args) throws Exception {
		ZSetOperations<String, String> zsetOperations=template.opsForZSet();
		String key = "spring.boot.redis.test.zset";
		if(!this.template.hasKey(key)){
			zsetOperations.add(key, "1", 10);
			zsetOperations.add(key, "1", 10);
			zsetOperations.add(key, "2", 20);
			zsetOperations.add(key, "3", 30);
			zsetOperations.add(key, "4", 40);
			System.out.println("add key " + key + ", value=" + zsetOperations.range(key, 0, zsetOperations.size(key)-1));
		}else{
			System.out.println("Found key " + key + ", value=" + ListUtil.printCollection(zsetOperations.range(key, 0, zsetOperations.size(key)-1)));
		}
	}

}
