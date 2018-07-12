package com.eran.thread.thread_class;

public class MyThread3 extends Thread {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("MyThread3的优先级别：" + Thread.currentThread().getPriority());
		}
		MyThread2 myThread2 = new MyThread2();
		myThread2.setPriority(10);
		myThread2.start();
	}
}
