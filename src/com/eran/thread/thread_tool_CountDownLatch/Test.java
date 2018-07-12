package com.eran.thread.thread_tool_CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	/*
	 * concurrent工具——CountDownLatch
	 * 
	 * 1.两个重要方法
	 * 		<1>countDown()
	 * 		<2>await()
	 * 2.这相当于是一种进化版本的等待/通知机制，它可以的实现的是多个工作线程完成任务后通知多个等待线程开始工作。
	 * 
	 */
	public static void main(String[] args) {
		System.out.println("******example1******");
//		CountDownLatch cdl = new CountDownLatch(3);
//		DoneThread doneThread1 = new DoneThread(cdl, "替补线程1");
//		DoneThread doneThread2 = new DoneThread(cdl, "替补线程2");
//		doneThread1.start();
//		doneThread2.start();
//		
//		WorkThread workThread1 = new WorkThread(cdl, 2, "工作线程1");
//		WorkThread workThread2 = new WorkThread(cdl, 3, "工作线程2");
//		WorkThread workThread3 = new WorkThread(cdl, 4, "工作线程3");
//		
//		workThread1.start();
//		workThread2.start();
//		workThread3.start();
		
		
		System.out.println("******example2,很能说明问题的一个例子******");
		final CountDownLatch startLatch = new CountDownLatch(1);   //模拟一个跑步名枪员锁
		final CountDownLatch endLatch = new CountDownLatch(10);  	//模仿十个运动员锁
		
		final ExecutorService exec = Executors.newFixedThreadPool(10);
		
		for(int i=0;i<10;i++) {
			final int no =  i + 1;
			Runnable run = new Runnable() {
				@Override
				public void run() {
					try {
						startLatch.await();
						Thread.sleep((long) (Math.random() * 10000));  
                        System.out.println("No." + no + " arrived");  
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}finally {
						endLatch.countDown();
					}
				}
			};
			exec.submit(run);
		}
		System.out.println("GAME START");
		startLatch.countDown();
		
		try {
			endLatch.await();
			System.out.println("GAME OVER");
			exec.shutdown();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
