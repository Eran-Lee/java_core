package com.eran.thread.thread_produce_customer_model;

public class Thread_Test {
	/*
	 * 利用wait()/notify()实现生产者消费者模式
	 * 1.什么是生产者消费者模型？
	 * 		一种重要的模型，基于等待/通知机制。生产者/消费者模型描述的是有一块缓冲区作为仓库，
	 * 		生产者可将产品放入仓库，消费者可以从仓库中取出产品，生产者/消费者模型关注的是以下几个点：
	 * 			<1>生产者生产的时候消费者不能消费
	 * 			<2>消费者消费的时候生产者不能生产
	 * 			<3>缓冲区空时消费者不能消费
				<4>缓冲区满时生产者不能生产
	
	 * 2.这种模型的好处？
	 * 		<1>解耦,弱耦合。
	 * 		<2>通过平衡生产者和消费者的处理能力来提高整体处理数据的速度，配置处理速度，提高效率。
	 * 
	 * 3.实现细节
	 * 
	 */

	public static void main(String[] args) {
		System.out.println("****************简单生产者消费者模式*************");
		// wait()/notify()实现简单生产者消费者模式
//		Object object = new Object();
//		final Customer customer = new Customer(object);
//		final Producer producer = new Producer(object);
		//生产者和消费者要不要连续消费是在外层继续控制的。
		//匿名内部类只能使用final修饰的对象。
//		Runnable customerRunnable = new Runnable() {
//			public void run() {
//				while(true) {
//					customer.getValue();
//				}
//			}
//		};
//		
//		Runnable producerRunnable = new Runnable() {
//			public void run() {
//				while(true) {
//					producer.setValue();
//				}
//			}
//		};
		
//		Thread threadCustomer = new Thread(customerRunnable);
//		Thread threadProducer = new Thread(producerRunnable);
//		
//		threadCustomer.start();
//		threadProducer.start();
		
		System.out.println("****************简单生产者消费者模式——假死*************");
		//全部线程进入wait()状态，不再执行任何业务
		//考虑如果有两个生产者，两个消费者，使用了同一把锁的话，当最后唤醒是唤醒同类，比如最后生产者唤醒生产者，就全部进入等待状态。
		//解决假死的办法就是使用notifyAll()
		
		
		System.out.println("****************一生产多消费者模式——操作栈*************");
		//if判断出现的问题，过程如下：
		// 		<1>比如生产者生产了数据，并通知了消费者去消费，这里有多个消费者。其中一个消费消费了，做了通知。
		//		<2>通知唤醒了另个一个消费者，另一个消费者发现缓存中仍然时空的，就挂起。让出锁。这个时候就出现了假死现象。
		//		<3>利用notifyAll（）解决假死问题
		//用while代替if，实现二次判断，用notifyAll()实现假死问题。
		MyStack myStack = new MyStack();
		P p = new P(myStack);
		P_Thread p_Thread = new P_Thread(p);
		p_Thread.start();
		
		C c = new C(myStack);
		C_Thread c_Thread = new C_Thread(c);
		C_Thread c_Thread2 = new C_Thread(c);
		C_Thread c_Thread3 = new C_Thread(c);
		C_Thread c_Thread4 = new C_Thread(c);
		
		c_Thread.start();
		c_Thread2.start();
		c_Thread3.start();
		c_Thread4.start();
		
		System.out.println("****************通过管道进行线程通信——字节流*************");
		
		System.out.println("****************通过管道进行线程通信——字符流*************");
		
	}

}
