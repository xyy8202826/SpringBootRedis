package com.xyy.lock;

import java.util.concurrent.TimeUnit;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RLock;

public class RemoteLockTest {

	public static void main(String[] args) throws Exception {
		Config config = new Config();
		config.useSingleServer().setAddress("127.0.0.1:6379");
		Redisson redisson = Redisson.create(config);
		RLock lock = redisson.getLock("testLock");
		lock.lock(15, TimeUnit.SECONDS);// 10s超时
	/*	for (int i = 0; i < 5; i++) {
			RLock lock = redisson.getLock("testLock");
			lock.lock(10, TimeUnit.SECONDS);// 10s超时
			logger.info("the lock client id is client{}", i);
			Thread.sleep(1000);
			logger.info("client{} unlock", i);
			lock.unlock();
		}*/
		//redisson.shutdown();

	}
}
