package com.xyy.lock;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RTopic;

public class RTopicTest2 {

	public static void main(String[] args) throws Exception {
		Config config = new Config();
		config.useSingleServer().setAddress("127.0.0.1:6379");
		Redisson redisson = Redisson.create(config);
		RTopic<String> topic=redisson.getTopic("topicTest");
		topic.publish("mess");
		topic.publish("mess2");
		topic.publish("mess3");
		Thread.sleep(10000);
		topic.publish("mess4");
	}
}
