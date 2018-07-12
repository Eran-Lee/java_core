package com.eran.thread.syn_tongbusuo;

public class Thread2 {

	public static void main(String[] args) {
		/*
		 *  1.synchronized关键字同步代码也有弊端的，比如A线程调用同步方法执行一个较长时间的任务
		 *	那么B线程必须等待比较长的时间。这种情况下可以尝试使用synchronized同步语句块来解决问题。
		 *	2.synchronized(this)的格式来同步代码块，其实Java还支持对"任意对象"作为对象监视器来
		 *	实现同步的功能。这个"任意对象"大多数是实例变量及方法的参数，使用格式为synchronized(非this对象)。
		 *	3.锁非this对象具有一定的优点：如果在一个类中有很多synchronized方法，这时虽然能实现同步，
		 *	但会受到阻塞，从而影响效率。但如果同步代码块锁的是非this对象，则synchronized(非this对象x)
		 *	代码块中的程序与同步方法是异步的，不与其他锁this同步方法争抢this锁，大大提高了运行效率。
		 *
		 *
		 *  4.细化synchronized(非this对象x)的三个结论

			synchronized(非this对象x)格式的写法是将x对象本身作为对象监视器，有三个结论得出：

			1、当多个线程同时执行synchronized(x){}同步代码块时呈同步效果

			2、当其他线程执行x对象中的synchronized同步方法时呈同步效果

			3、当其他线程执行x对象方法中的synchronized(this)代码块时也呈同步效果
		 */
		
		//同步方法、同步块的各种例子
		System.out.println("**************例1，实现资源竞争的另一种方式，个人感觉是组常用的*****************");
//		CoreResource coreResource = new CoreResource();
//		MyThread th1 = new MyThread(coreResource);
//		th1.setName("worker1");
//		MyThread th2 = new MyThread(coreResource);
//		th2.setName("worker2");
//
//		th1.start();
//		th2.start();
		
		System.out.println("**************例2，synchronized块获得的是一个对象锁，换句话说，synchronized块锁定的是整个对象,不甚理解*****************");
//		CoreResource coreResource = new CoreResource();
//		MyThread2 thread2 = new MyThread2(coreResource); thread2.setName("work1");
//		MyThread3 thread3 = new MyThread3(coreResource); thread3.setName("work2");
//		
//		thread2.start();
//		thread3.start();
		
		System.out.println("**************例2，将任意对象作为对象监视器*****************");

		
	}

}
