package com.eran.thread.thread_sisuo;

public class DeadLock {
	
	private Object left = new Object();
	
	private Object right = new Object();

	public void leftMethod() throws InterruptedException {
		synchronized (left) {
			Thread.sleep(2000);
			synchronized (right) {
				System.out.println("左边的方法");
			}
		}
	}
	
	public void rightMethod() throws InterruptedException {
		synchronized (right) {
			Thread.sleep(2000);
			synchronized (left) {
				System.out.println("左边的方法");
			}
		}
	}

}
