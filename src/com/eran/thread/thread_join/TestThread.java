package com.eran.thread.thread_join;

public class TestThread {
	
	/*
	 * join()方法
	 * 1.使用背景：主线程需要等子线程执行完毕再执行，看起来就好像是同步。
	 * 2.join方法实际上调用了wait方法，所以是让锁的，sleep是不让锁的。
	 * 
	 */
	
	public static void main(String[] args) throws InterruptedException {
//		System.out.println("****join（）方法****");
//		MyThread myThread = new MyThread();
//		try {
//			myThread.start();
//			myThread.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//		System.out.println("我是主线程，我他妈已经完事了");
		
		System.out.println("*******join()强锁带来的陷阱********");
			ThreadB threadB = new ThreadB();
			ThreadA threadA = new ThreadA(threadB);
			threadB.start();
			threadA.start();
			threadB.join(2000);	//此处的join会抢锁，会导致结果执行不一样。
			System.out.println("main out");
		
	}
}
