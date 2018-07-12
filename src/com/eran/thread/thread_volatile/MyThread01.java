package com.eran.thread.thread_volatile;

public class MyThread01 extends Thread{
	private volatile boolean isRunning = true;
	
	public boolean isRunning() {
		return this.isRunning;
	}
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("进入run");
		while(isRunning) {
		}
		System.out.println("线程被停止");
	}
	

}
