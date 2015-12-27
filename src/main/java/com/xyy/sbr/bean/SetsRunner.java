package com.xyy.sbr.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.xyy.sbr.util.ListUtil;

public class SetsRunner implements CommandLineRunner{
	@Autowired
	private StringRedisTemplate template;
	@Override
	public void run(String... args) throws Exception {
		SetOperations<String, String> setOperations=template.opsForSet();
		String key = "spring.boot.redis.test.set";
		String[] data={"1","1","2","3"};
		if(!this.template.hasKey(key)){
			setOperations.add(key, data);
			System.out.println("add key " + key + ", value=" + data);
		}else{
			System.out.println("Found key " + key + ", value=" + ListUtil.printCollection(setOperations.members(key)));
		}
	}

}
