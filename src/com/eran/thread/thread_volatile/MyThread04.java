package com.eran.thread.thread_volatile;

public class MyThread04 extends Thread{
	private boolean isRunning = true;
	
	public boolean isRunning() {
		return this.isRunning;
	}
	
	public void setRunning(boolean isRunning) {
		this.isRunning = isRunning;
	}
	
	@Override
	public void run() {
		System.out.println("进入run");
		String str = new String();
		while(isRunning) {
			synchronized (str) {
				
			}
		}
		System.out.println("线程被停止");
	}
	

}
