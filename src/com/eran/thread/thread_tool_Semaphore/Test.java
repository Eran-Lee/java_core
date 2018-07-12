package com.eran.thread.thread_tool_Semaphore;

import java.util.concurrent.Semaphore;

public class Test {
	/*
	 * Semaphore(旗语)
	 * 1.Semaphore实现的功能就类似厕所有5个坑，假如有10个人要上厕所，那么同时只能有多少个人去上厕所呢？
	 * 	同时只能有5个人能够占用，当5个人中 的任何一个人让开后，其中等待的另外5个人中又有一个人可以占用了。
	 * 	另外等待的5个人中可以是随机获得优先机会，也可以是按照先来后到的顺序获得机会，这取决于构造Semaphore对象
	 * 	时传入的参数选项。单个信号量的Semaphore对象可以实现互斥锁的功能，并且可以是由一个线程获得了“锁”，
	 * 	再由另一个线程释放“锁”，这可应用于死锁恢复的一些场合。Semaphore在实现这种排队机制的时候很优秀，代码简洁
	 * 
	 * 2.Semaphore是非常有用的一个组件，它相当于是一个并发控制器，是用于管理信号量的。构造的时候传入可供管理的信号量的数值，
	 * 	这个数值就是控制并发数量的，就是同时能几个线程访问。我们需要控制并发的代码，执行前先通过acquire方法获取信号，
	 * 	执行后通过release归还信号 。每次acquire返回成功后，Semaphore可用的信号量就会减少一个，如果没有可用的信号，
	 * 	acquire调用就会阻塞，等待有release调用释放信号后，acquire才会得到信号并返回。
	 * 
	 * 3.ReentrantLock 实现的生产/消费者一对一情况下 ，对比Semaphore 代码更复杂，但是在多个生产/消费的况，
	 *   ReentrantLock虽然代码比较复杂，但是更高效 。
	 *   
	 * 4.Semaphore分为单值和多值两种
	 * 	<1>单值的Semaphore管理的信号量只有1个，该信号量只能被1个，只能被一个线程所获得，意味着并发的代码只能被一个线程运行，这就相当于是一个互斥锁了
	 *  <2>多值的Semaphore管理的信号量多余1个，主要用于控制并发数
	 *  
	 *  5.这种通过Semaphore控制并发并发数的方式和通过控制线程数来控制并发数的方式相比，粒度更小，
	 *    因为Semaphore可以通过acquire方法和release方法来控制代码块的并发数。
	 */
	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(5);
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					semaphore.acquire();
					System.out.println(Thread.currentThread().getName() + "获得了信号量,时间为" + System.currentTimeMillis());
					Thread.sleep(2000);
					System.out.println(Thread.currentThread().getName() + "释放了信号量，时间为" + System.currentTimeMillis());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					semaphore.release();
				}
			}
		};
		
		Thread[] threads = new Thread[10];
		for(int i=0;i<threads.length;i++) {
			threads[i] = new Thread(runnable);
		}
		for(int i=0;i<threads.length;i++) {
			threads[i].start();
		}
	}
}
