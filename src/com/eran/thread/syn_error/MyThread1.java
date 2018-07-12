package com.eran.thread.syn_error;

public class MyThread1 extends Thread {
	private MyList list;

	public MyThread1(MyList list) {
		super();
		this.list = list;
	}
	
	@Override
	public void run() {
		MyService myService = new MyService();
		myService.addServiceMethod(list, "thread1");
	}
	
}
