package com.eran.thread.thread_sisuo;

public class MyThread01 extends Thread{
	private DeadLock dl;
	
	public MyThread01(DeadLock dl) {
		this.dl = dl;
	}
	
	@Override
	public void run() {
		try {
			dl.leftMethod();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
