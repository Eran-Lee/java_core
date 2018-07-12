package com.eran.thread.thread_join;

public class MyThread extends Thread {
	

	
	@Override
	public void run() {
//		int second = (int)(Math.random() * 1000);
		int second = 3000;
		System.out.println("子线程要睡：" + second + "秒");
		try {
			Thread.sleep(second);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
