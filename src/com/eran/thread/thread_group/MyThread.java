package com.eran.thread.thread_group;

public class MyThread implements Runnable{

	@Override
	public void run() {
		
		while(!Thread.currentThread().isInterrupted()) {
			System.out.println("ThreadName =" + Thread.currentThread().getName());
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
