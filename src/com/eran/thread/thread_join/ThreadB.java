package com.eran.thread.thread_join;

public class ThreadB extends Thread{
	@Override
	synchronized public void run() {
		System.out.println("B begin:" + System.currentTimeMillis());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("B end:" + System.currentTimeMillis());
	}

}
