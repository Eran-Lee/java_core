package com.eran.thread.thread_ReentranLock_Condition;

import java.util.concurrent.locks.ReentrantLock;

public class MyService {
	private ReentrantLock lock = new ReentrantLock();
	
	public void serviceA() {
		lock.lock();
		for(int i=0;i<4;i++) {
			 System.out.println("ThreadName = " + Thread.currentThread().getName() + 
                     ", i  = " + i);
		}
		lock.unlock();
	}
	
	public void serviceB() {
		try {
			lock.lock();
			System.out.println("methodB begin ThreadName = " + Thread.currentThread().getName());
			Thread.sleep(5000);
			System.out.println("methodB end ThreadName = " + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public void serviceC() {
	        System.out.println("MethodC begin ThreadName = " + Thread.currentThread().getName());
	        System.out.println("MethodC end ThreadName = " + Thread.currentThread().getName());
	}

}
