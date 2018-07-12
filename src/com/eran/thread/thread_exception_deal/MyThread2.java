package com.eran.thread.thread_exception_deal;

public class MyThread2 extends Thread{
	private String num = "";
	
	public MyThread2(ThreadGroup tg, String name, String num) {
		super(tg, name);
		this.num = num;
	}
	
	@Override
	public void run() {
		int parseInt = Integer.parseInt(num);
		while(!this.isInterrupted()) {
			System.out.println("死循环中：" + Thread.currentThread().getName());
		}
	}

}
