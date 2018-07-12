package com.eran.thread.threadPool;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThread {
	private static long currentTimeMillis;

	/*
	 * 线程池
	 * 1.线程池的作用
	 * 		1>减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务,降低资源开销；
	 * 		2>多出的资源可以提高系统的处理能力，提高效率
	 * 2.线程对象和工作线程的区别：工作线程是一串已经开辟执行线程处理的内存，线程对象就是任务。这样就可以防止1000个任务，开辟
	 * 	 1000个线程，只用100个线程重复利用，可以降低线程开销，线程调度、切换对系统资源的占用。
	 * 
	 * 3.线程池的类结构
	 * 	
	 * 4.ThreadPoolExecutor的使用很简单，但jdk中的一句话：强烈建议程序员使用较为方便的Executors工厂方法Executors.newCachedThreadPool()
	 * 	（无界线程池，可以进行线程自动回收）、Executors.newFixedThreadPool(int)（固定大小线程池）和
	 * 	 Executors.newSingleThreadExecutor()（单个后台线程），它们均为大多数使用场景预定义了设置。
	 * 
	 * 5.Executors线程工具类
	 * 		1>Executors.newSingleThreadExecutor(),创建一个单线程池，workQueue选择的是无界的（大小没有限制的）的LinkedBlockingQueue,所以
	 * 		  MaximumPoolSize也就没有了意义，线程不会被回收。
	 * 		2>Executors.newFixedThreadPool(int nThreads),创建一个固定大小的线程池，线程不会被回收。
	 * 		3>Executors.newCachedThreadPool(),创建一个无界线程池，无论来多少任务都是直接运行，workQueue是synchronizedQueu,所以不用排队，
	 * 		  放进来，立马拿走，线程数量也是近似的无限大Integer.MAX_VALUE，线程等待时间是60s。
	 * 
	 * 6.workQueue
	 * 		<1>任务队列，根据队列工具类有三种策略：直接提交（SynchronizedQueue），有界队列(ArrayBlockingQueue)，无界队列(LinkedBlockingQueue)
	 * 		<2>JDK中采用了直接提交和无界队列
	 * 		<3>最后还是那句话，就像Comparable和Comparator的对比、synchronized和ReentrantLock，再到这里的无界队列和有界队列的对比，
	 * 		   看似都有一个的优点稍微突出一些，但是这绝不是鼓励大家使用一个而不使用另一个，任何东西都需要根据实际情况来，当然在一开始的
	 * 		   时候可以重点考虑那些看上去优点明显一点的。
	 * 
	 * 7.拒绝策略
	 * 		<1>所谓拒绝策略之前也提到过了，任务太多，超过maximumPoolSize了怎么把？当然是接不下了，接不下那只有拒绝了。拒绝的时候可以
	 * 			指定拒绝策略，也就是一段处理程序。
	 * 		<2>决绝策略的父接口是RejectedExecutionHandler，JDK本身在ThreadPoolExecutor里给用户提供了四种拒绝策略，看一下：
	 * 			1>AbortPolicy:直接抛出一个RejectedExecutionException，这也是JDK默认的拒绝策略
	 * 			2>CallerRunsPolicy:尝试直接运行被拒绝的任务，如果线程池已经被关闭了，任务就被丢弃了
	 * 			3>DiscardOldestPolicy:移除最晚的那个没有被处理的任务，然后执行被拒绝的任务。同样，如果线程池已经被关闭了，任务就被丢弃了
	 * 			4>DiscardPolicy:不能执行的任务将被删除


	 */
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("**********不适用线程池*********");
//		long startTime = System.currentTimeMillis();
//		final LinkedList<Integer> linkedList = new LinkedList<Integer>();
//		final Random random = new Random();
//		for(int i=0;i<20000;i++) {
//			Thread thread = new Thread() {
//				public void run() {
//					linkedList.add(random.nextInt());
//				}
//			};
//			thread.start();
//			try {
//				thread.join();
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
//		System.out.println(System.currentTimeMillis() - startTime);
//		System.out.println("linkedList的大小：" + linkedList.size());
		
		System.out.println("**********使用线程池*********");
		long startTime = System.currentTimeMillis();
		final LinkedList<Integer> linkedList = new LinkedList<Integer>();
		ThreadPoolExecutor tp = new ThreadPoolExecutor(100, 100, 20, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
		final Random random = new Random();
		for(int i=0;i<20000;i++) {
			tp.execute(new Runnable() {
				@Override
				public void run() {
					linkedList.add(random.nextInt());
				}
			});
			
		}
		tp.shutdown();
		tp.awaitTermination(1, TimeUnit.DAYS);
		System.out.println(System.currentTimeMillis() - startTime);
		
		System.out.println("linkedList的大小：" + linkedList.size());
	}

}
