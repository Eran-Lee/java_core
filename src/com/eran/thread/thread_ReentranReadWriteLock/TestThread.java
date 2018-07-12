package com.eran.thread.thread_ReentranReadWriteLock;

public class TestThread {
	/*
	 * ReentrantReadWriteLock知识点
	 * 
	 * 1.大型网站中很重要的一块内容就是数据的读写，ReentrantLock虽然具有完全互斥排他的效果（即同一时间只有一个线程正在执行lock后面的任务），
	 * 但是效率非常低。所以在JDK中提供了一种读写锁ReentrantReadWriteLock，使用它可以加快运行效率。
	 * 2.多个Thread可以同时进行读取操作，但是同一时刻只允许一个Thread进行写入操作
	 */

	public static void main(String[] args) {
		System.out.println("*****1******");
		//读和读之间不涉及线程安全问题，两个线程可以同时进入
		final ThreadDomain threadDomain = new ThreadDomain();
		Runnable runnable = new Runnable() {
			public void run () {
				threadDomain.read();
			}
		};
		
		Thread t1 = new Thread(runnable);
		Thread t2 = new Thread(runnable);
		
		t1.start();
		t2.start();
		/*
		 * 输出结果
		 *  Thread-0获得了读锁，时间为1531151286989
			Thread-1获得了读锁，时间为1531151286989
			
			那么这里的读锁还有什么意义呢？那了在读写的时候，给读加上锁，这样写就不能再获得锁了
		 */
		
		System.out.println("*****2******");
		//写与写之间互斥，涉及线程安全问题
		final ThreadDomain threadDomain2 = new ThreadDomain();
		Runnable runnable2 = new Runnable() {
			public void run() {
				threadDomain2.write();
			}
		};
		
		Thread thread1 = new Thread(runnable2);
		Thread thread2 = new Thread(runnable2);
		thread1.start();
		thread2.start();
		
		System.out.println("********3*******");
		//读和写之间互斥，涉及线程安全
		final ThreadDomain threadDomain3 = new ThreadDomain();
		Runnable runnable3 = new Runnable() {
			public void run() {
				threadDomain3.read();
			}
		};
		
		Runnable runnable4 = new Runnable() {
			public void run() {
				threadDomain3.write();
			}
		};
		
		new Thread(runnable3).start();
		new Thread(runnable4).start();
		
		
	}

}
