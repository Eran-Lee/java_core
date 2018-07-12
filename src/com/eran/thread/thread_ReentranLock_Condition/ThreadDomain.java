package com.eran.thread.thread_ReentranLock_Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDomain {
	
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	

	public void await() {
		try {
		lock.lock();
			System.out.println("await时间：" + System.currentTimeMillis());
			condition.await();
			System.out.println("await结束");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void asignal() {
		try {
			lock.lock();
			System.out.println("asignal时间：" + System.currentTimeMillis());
			condition.signal();	
		}finally {
			lock.unlock();
		}
	}
	
}
