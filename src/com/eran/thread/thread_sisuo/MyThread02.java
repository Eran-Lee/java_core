package com.eran.thread.thread_sisuo;

public class MyThread02 extends Thread{
	private DeadLock dl;
	
	public MyThread02(DeadLock dl) {
		this.dl = dl;
	}
	
	@Override
	public void run() {
		try {
			dl.rightMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
