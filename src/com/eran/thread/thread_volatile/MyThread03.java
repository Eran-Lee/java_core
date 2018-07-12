package com.eran.thread.thread_volatile;

public class MyThread03 extends Thread{
	private static int count;
	
	synchronized private static void addCount() {
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
