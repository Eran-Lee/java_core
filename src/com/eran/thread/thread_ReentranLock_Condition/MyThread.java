package com.eran.thread.thread_ReentranLock_Condition;

public class MyThread extends Thread {
	private MyService service;
	
	public MyThread(MyService service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		service.serviceA();
	}

}
