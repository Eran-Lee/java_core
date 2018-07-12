package com.eran.thread.thread_ReentranLock_Condition;

public class MyThread4 extends Thread {
	private ThreadDomain service;
	
	public MyThread4(ThreadDomain service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		service.await();
	}

}
