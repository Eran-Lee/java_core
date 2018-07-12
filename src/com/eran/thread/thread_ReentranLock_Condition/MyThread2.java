package com.eran.thread.thread_ReentranLock_Condition;

public class MyThread2 extends Thread {
	private MyService service;
	
	public MyThread2(MyService service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		service.serviceB();
	}

}
