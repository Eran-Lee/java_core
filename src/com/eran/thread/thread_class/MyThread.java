package com.eran.thread.thread_class;

public class MyThread extends Thread {

	@Override
	public void run() {
		for (int j = 0; j < 10; j++) {
			long begin = System.currentTimeMillis();
			int count = 0;
			for (int i = 0; i < 5000000; i++) {
				Thread.yield();
				count = count + i + 1;
			}
			long end = System.currentTimeMillis();
			System.out.println("用时：" + (end - begin));
		}
	}
}
