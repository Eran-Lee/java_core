package com.eran.thread.thread_ReentranLock_Condition;

import java.util.concurrent.locks.Condition;

public class TestThread {
	/*
	 * ReenTranLock&Condition使用
	 * 	1.ReenTranLock
	 * 		<1>ReentrantLock，一个可重入的互斥锁，它具有与使用synchronized方法和语句所访问的隐式监视器锁相同的一些基本行为和语义，
	 * 		   但功能更强大。
	 * 		<2>ReentrantLock和synchronized持有的对象监视器不同，可以理解为ReentrantLock锁的就是lock这个对象，
	 * 		   而synchronized锁的是当前这个类的对象,另外千万别忘了，ReentrantLock持有的锁是需要手动去unlock()的。
	 * 		<3>ReenTranLock类中还有其他很多方法。
	 * 
	 *  2.Condition
	 *  	<1>synchronized与wait()和nitofy()/notifyAll()方法相结合可以实现等待/通知模型，ReentrantLock同样可以，
	 *  		但是需要借助Condition，且Condition有更好的灵活性，具体体现在:
	 *  		1> 一个Lock里面可以创建多个Condition实例，实现多路通知。
	 *  		2> notify()方法进行通知时，被通知的线程时Java虚拟机随机选择的，
	 *  			但是ReentrantLock结合Condition可以实现有选择性地通知，这是非常重要的。
	 *  		3>利用Condition实现等待/通知模型的最简单用法，下面的代码注意一下，await()和signal()之前，必须要先lock()获得锁，
	 *  			使用完毕在finally中unlock()释放锁，这和wait()/notify()/notifyAll()使用前必须先获得对象锁是一样的。
	 *  
	 *  
	 *  
	 */

	
	public static void main(String[] args) {
		System.out.println("***************");
//		MyService myService = new MyService();
//		
//		MyThread thread1 = new MyThread(myService);
//		MyThread thread2 = new MyThread(myService);
//		MyThread thread3 = new MyThread(myService);
//		
//		thread1.start();
//		thread2.start();
//		thread3.start();
		
		
		
		
		System.out.println("***************");
//		MyService service = new MyService();
//		MyThread2 myThread2 = new MyThread2(service);
//		MyThread3 myThread3 = new MyThread3(service);
//		
//		myThread2.start();
//		myThread3.start();
		
		
		System.out.println("***************");
		ThreadDomain threadDomain = new ThreadDomain();
		MyThread4 myThread4 = new MyThread4(threadDomain);
		myThread4.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		threadDomain.asignal();
	}

}
