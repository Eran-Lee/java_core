package com.eran.thread.thread_wait_notify;

public class MyThread02 extends Thread {
	private Object lock;

	public MyThread02(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		synchronized (lock) {
			System.out.println("开始---------notify time = " + System.currentTimeMillis());
			lock.notify();
			System.out.println("结束---------notify time = " + System.currentTimeMillis());
		}
	}

}
