package com.eran.thread.thread_ReentranLock_Condition;

public class MyThread3 extends Thread {
	private MyService service;
	
	public MyThread3(MyService service) {
		this.service = service;
	}
	
	@Override
	public void run() {
		service.serviceC();
	}

}
