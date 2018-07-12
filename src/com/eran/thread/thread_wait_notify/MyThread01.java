package com.eran.thread.thread_wait_notify;

public class MyThread01 extends Thread {
	private Object lock;

	public MyThread01(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		try {
			synchronized (lock) {
				System.out.println("开始---------wait time = " + System.currentTimeMillis());
				lock.wait();
				System.out.println("结束---------wait time = " + System.currentTimeMillis());
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
