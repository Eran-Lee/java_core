package com.eran.thread.thread_Callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class TestThread {
	/*
	 * Callable
	 * 1.可以返回线程结果的Runnable
	 * 
	 * Future
	 * 1.线程异步返回的结果，提供了计算是否完成的方法，并获取结果。常用方法get(),cancel(),isCancel(),isDone()四个方法。
	 * 2.所以共有三个功能，判断是否完成，中断任务，获取结果。
	 * 3.Future.get会阻塞,直到Callable中线程任务执行完毕，效率低下,可以用FutureTask代替。
	 * 
	 * FutureTask
	 * 1.FutureTask是Future的实现类，也可以说是进阶类，优化了Future的一些缺点，比如Future.get会阻塞等等，它提供了对Future的基本实现。
	 *   可使用FutureTask包装Callable或Runnable对象，因为FutureTask实现了Runnable和Future（看源码可以看出来），所以也可以
	 *   将FutureTask提交给Executor。一般使用FutureTask代替Future即可。
	 * 2.Callable、Future、FutureTask一般都是和线程池配合使用的，因为线程池ThreadPoolExecutor的父类AbstractExecutorService提供了三种submit方法
	 *   
	 * 使用Callable、Future、FutureTask的好处
	 * 1.是任务异步，提高效率
	 * 2.JDK帮我们很好地实现好了代码细节，让开发者更多可以关注业务层的逻辑。
	 */
	
	public static class CallableThread implements Callable<String>{

		@Override
		public String call() throws Exception {
			System.out.println("进入CallableThread的call()方法, 开始睡觉, 睡觉时间为" + System.currentTimeMillis());
	        Thread.sleep(10000);
	        System.out.println("线程睡眠10s返回，返回123");
	        return "123";
		}
	}
	
	public static class FutureTaskThread extends FutureTask<String>{

		public FutureTaskThread(Callable<String> callable) {
			super(callable);
		}
		
		@Override
		protected void done() {
			super.done();
			
			try {
				String str = this.get();
				 System.out.println("FutureTask已拿到数据, str = " + str + ", 当前时间为" + System.currentTimeMillis());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("***********Callable+Future**************");
//		ExecutorService es = Executors.newCachedThreadPool();
//		CallableThread ct = new CallableThread();
//		Future<String> res = es.submit(ct);
//		es.shutdown();
//		
//	    Thread.sleep(5000);
//	    System.out.println("主线程等待5秒, 当前时间为" + System.currentTimeMillis());
//	    
//	    String string = res.get();
//	    System.out.println("Future已拿到数据, str = " + string + ", 当前时间为" + System.currentTimeMillis());
	    
	    System.out.println("***********Callable+FutureTask**************");
	    ExecutorService es = Executors.newCachedThreadPool();
	    CallableThread callableThread = new CallableThread();
	    FutureTaskThread futureTask = new FutureTaskThread(callableThread);
	    es.submit(futureTask);
	    es.shutdown();
	    
	    System.out.println("主线程执行完毕，当前时间：" + System.currentTimeMillis());
	}

}
