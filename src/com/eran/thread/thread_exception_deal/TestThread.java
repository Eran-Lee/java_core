package com.eran.thread.thread_exception_deal;

import java.lang.Thread.UncaughtExceptionHandler;

public class TestThread {
	/*
	 * 线程异常处理 
	 * 1.使用UncaughtExceptionHandler类处理，即给具体的线程对象设置异常处理器；
	 * 2.给类设置setDefaultUncaughtExceptionHandler，所有具体的类都能够被处理； 
	 * 3.如果手动在线程内try catch了，那么就不会进入以上两种自己设置的异常了
	 * 
	 * 
	 * 线程组异常
	 * 1.默认是线程组内的一个线程异常，别的线程继续运行。
	 * 1.为了实现别的线程停止的效果，可以通过继承ThreadGroup类，重写uncaughtException（）方法实现。
	 */

	public static void main(String[] args) {
		System.out.println("************");
		// MyThread myThread = new MyThread();
		// myThread.start();

		System.out.println("************");
		// MyThread myThread = new MyThread();
		// myThread.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
		// @Override
		// public void uncaughtException(Thread t, Throwable e) {
		// System.out.println("线程：" + t.getName() + "出现了异常");
		// e.printStackTrace();
		// }
		// });
		// myThread.start();
		// MyThread myThread2 = new MyThread();
		// myThread2.start();

		System.out.println("***********");
		// MyThread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {
		//
		// @Override
		// public void uncaughtException(Thread t, Throwable e) {
		// System.out.println("线程：" + t.getName() + "出现了异常");
		// }
		// });
		//
		// MyThread myThread = new MyThread();
		// MyThread myThread2 = new MyThread();
		//
		// myThread.start();
		// myThread2.start();

		System.out.println("***********");
		MyThreadGroup group1 = new MyThreadGroup("组1");
		for (int i = 0; i < 5; i++) {
			MyThread2 myThread2 = new MyThread2(group1, "TH" + i, i + "");
			myThread2.start();
		}
		new MyThread2(group1, "THH", "A").start();
		;
	}

}
