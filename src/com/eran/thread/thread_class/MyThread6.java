package com.eran.thread.thread_class;

public class MyThread6 extends Thread {
	
	private long i = 0;

	@Override
	public void run() {
		while(true) {
			i++;
			System.out.println(i);
		}
	}
}
