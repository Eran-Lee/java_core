package com.eran.thread.thread_produce_customer_model2;

public class TestThread {

	public static void main(String[] args) {
		/*
		 * 利用ReentranLock的await()/signal()实现生产者消费者模式
		 * 
		 * 1.实现方式和wait()/notify()/notifyAll()类似
		 * 2.同样可能出现假死现象，处理办法
		 * 		<1>synchronized用notifyAll()唤醒所有线程、ReentrantLock用signalAll()唤醒所有线程。
		 * 		<2>用ReentrantLock定义两个Condition，一个表示生产者的Condition，一个表示消费者的Condition，
		 * 			唤醒的时候调用相应的Condition的signal()方法就可以了。这里显得更加效率，方便要实现生产消费模型，
		 * 			java提供了队列机制更加方便的实现生产者消费者模式。
		 */
		
		final ThreadDomain threadDomain = new ThreadDomain();
		Runnable customer = new Runnable() {
			public void run() {
				for(int i=0;i<5;i++) {
					threadDomain.get();
				}
			}
		};
		
		Runnable producer = new Runnable() {
			public void run() {
				for(int j=0;j<5;) {
					threadDomain.set();
				}
			}
		};
		
		new Thread(producer).start();
		new Thread(customer).start();
	}
	
	

}
