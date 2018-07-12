package com.eran.thread.thread_class;

import com.eran.thread.syn_tongbusuo.Thread2;

public class ThreadClassTest {

	public static void main(String[] args) throws InterruptedException {
		// Thread中的方法测试
		
		System.out.println("***********static方法——yield()************");
		//暂停当前执行的线程对象，并执行其他线程。这个暂停是会放弃CPU资源的，并且放弃CPU的时间不确定，
		//有可能刚放弃，就获得CPU资源了，也有可能放弃好一会儿，才会被CPU执行。yield也不会放开锁。
//		MyThread myThread = new MyThread();
//		myThread.start();
		
		System.out.println("***********static方法——interrupted()************");
		//测试当前线程是否已经中断，执行后具有将状态标识清除为false的功能。换句话说，如果连续两次调用该方法，那么返回的必定是false：
//		Thread.currentThread().interrupt();
//		System.out.println("是否中断1：" + Thread.interrupted());
//		System.out.println("是否中断2：" + Thread.interrupted());
		
		System.out.println("***********线程的优先级——继承性************");
		//线程优先级别是会继承的，线程1中调用别的调用线程2，线程1设置优先级别，2没有，那么2就是和1一样的级别
//		MyThread2 myThread2 = new MyThread2();
//		myThread2.setPriority(1);
		
		System.out.println("***********线程的优先级——优先级的设定就是鸡肋************");
//		MyThread4 myThread4 = new MyThread4();
//		myThread4.setPriority(10);
//		myThread2.start();
//		myThread4.start();
		
		System.out.println("***********线程——中断机制——interrupted()************");
		/*
		 * 1.run()方法运行完
		 * 2.stop() 已放弃
		 * 3.interrupt()方法优雅的中断线程
		 * 4.静态interrupted()方法、非静态的isInterrupted()方法
		 */
//		MyThread4 myThread4 = new MyThread4();
//		myThread4.start();
//		Thread.sleep((long)2000);
//		myThread4.interrupt();
//		Thread.currentThread().interrupt();
//		System.out.println("是否停止1：" + myThread4.interrupted());	//这静态方法这么用，有个毛用啊；
//		System.out.println("是否停止2：" + myThread4.interrupted());
		
		System.out.println("***********线程——中断机制——isInterrupted()************");
//		MyThread4 myThread5 = new MyThread4();
//		myThread5.start();
//		Thread.sleep((long)2000);
//		myThread5.interrupt();
//		Thread.currentThread().interrupt();
//		System.out.println("是否停止1：" + myThread5.isInterrupted());	//非静态方法这么用，有个毛用啊；
//		System.out.println("是否停止2：" + myThread5.isInterrupted());
		
		System.out.println("***********线程——中断机制——优雅的中断Java程序************");
//		 try {
//	            MyThread5 thread5 = new MyThread5();
//	            thread5.start();
//	            Thread.sleep(2000);
//	            thread5.interrupt();//请求中断MyThread线程
//	        } catch (InterruptedException e) {
//	            System.out.println("main catch");
//	            e.printStackTrace();
//	        }
//	        System.out.println("end!");
		
		System.out.println("***********1线程——废除的suspend&resume************");
		//1.会造成独占，从而造成死锁,导致下面一句话打不出来（println()源码中有同步上锁）
		//suspend作废的原因？
//		MyThread6 myThread6 = new MyThread6();
//		myThread6.start();
//		Thread.sleep(1000);
//		myThread6.suspend();	
//		System.out.println("main end!");
		
		System.out.println("***********2线程——废除的suspend&resume************");
		//1.会造成数据不同步破坏数据的原子性
//		final MyObject myObject = new MyObject();
//		Thread thread = new Thread() {
//			public void run() {
//				myObject.setValue("a", "aa");
//			}
//		};
//		thread.setName("a");
//		thread.start();
//		Thread.sleep(500);
//		Thread thread2 = new Thread(){
//			public void run() {
//				myObject.printUserNamePassword();
//			}
//		};
//		thread2.start();
	}

}
