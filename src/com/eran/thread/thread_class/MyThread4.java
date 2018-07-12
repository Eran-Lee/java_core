package com.eran.thread.thread_class;

public class MyThread4 extends Thread {

	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			try {
				Thread.currentThread().sleep((long)10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("MyThread4的优先级：" + Thread.currentThread().getPriority());
		}
	}
}
