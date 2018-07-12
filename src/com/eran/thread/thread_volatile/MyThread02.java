package com.eran.thread.thread_volatile;

public class MyThread02 extends Thread{
	private volatile static int count;
	
	private static void addCount() {
		for(int i=0;i<1000;i++) {
			count++;
		}
		System.out.println("count: " + count);
	}
	

	
	@Override
	public void run() {
			addCount();
	}
	

}
