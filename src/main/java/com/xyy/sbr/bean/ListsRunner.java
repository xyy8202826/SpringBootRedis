package com.xyy.sbr.bean;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import com.xyy.sbr.util.ListUtil;

public class ListsRunner implements CommandLineRunner{
	@Autowired
	private StringRedisTemplate template;
	@Override
	public void run(String... args) throws Exception {
		ListOperations<String, String> listOperations=template.opsForList();
		String key = "spring.boot.redis.test.list";
		List<String> data=new ArrayList<String>();
		data.add("1");
		data.add("1");
		data.add("2");
		data.add("3");
		if(!this.template.hasKey(key)){
			listOperations.leftPushAll(key, data);
			System.out.println("add key " + key + ", value=" + ListUtil.printCollection(data));
		}else{
			System.out.println("Found key " + key + ", value=" + ListUtil.printCollection(listOperations.range(key, 0, listOperations.size(key)-1)));
		}
	}

}
