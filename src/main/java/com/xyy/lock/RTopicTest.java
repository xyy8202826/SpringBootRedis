package com.xyy.lock;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.MessageListener;
import org.redisson.core.RTopic;

public class RTopicTest {

	public static void main(String[] args) throws Exception {
		Config config = new Config();
		config.useSingleServer().setAddress("127.0.0.1:6379");
		Redisson redisson = Redisson.create(config);
		RTopic<String> topic=redisson.getTopic("topicTest");
		topic.addListener(new MessageListener<String>(){
			@Override
			public void onMessage(String channel, String msg) {
				System.out.println("get message: "+msg);
				
			}
		});
	}
}
