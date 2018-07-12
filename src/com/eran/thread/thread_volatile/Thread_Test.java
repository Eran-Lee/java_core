package com.eran.thread.thread_volatile;

public class Thread_Test {

	public static void main(String[] args) throws InterruptedException {
		System.out.println("**********************volatile关键字，可以解决可见性************************");
		/*
		 * 1.volatile关键字：
		 * 		<1>可以保持主内存和线程工作内存中变量的的实时同步，相当与工作内存使用了主内存的数据。
		 * 		<2>volatile的致命问题就是不能支持原子性。
		 */		
//		MyThread01 myThread01 = new MyThread01();
//		myThread01.start();
//		Thread.sleep(1000);
//		myThread01.setRunning(false);
//		System.out.println("结束了");
		
		System.out.println("**********************synchronized关键字，可以也可以解决可见性************************");
//		MyThread04 myThread04 = new MyThread04();
//		myThread04.start();
//		Thread.sleep(1000);
//		myThread04.setRunning(false);
//		System.out.println("结束了");
		
		System.out.println("**********************volatile关键字——不能保证原子性************************");
//		MyThread02[] threads = new MyThread02[100];
//		for(int i=0;i<100;i++) {
//			threads[i] = new MyThread02();
//		}
//		for(int i=0;i<100;i++) {
//			threads[i].start();
//		}
		
		System.out.println("**********************利用synchronize保证原子性************************");
		/*
		 * 多线程围绕着可见性和原子性展开
		 * 	<1>保证了原子性的synchronize,同时也保证了可见性。
		 */
//		MyThread03[] threads = new MyThread03[100];
//		for(int i=0;i<100;i++) {
//			threads[i] = new MyThread03();
//		}
//		for(int i=0;i<100;i++) {
//			threads[i].start();
//		}
	}

}
