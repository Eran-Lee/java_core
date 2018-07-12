package com.eran.thread.thread_Timer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestThread {
	/*
	 * Timer学习
	 * 1.定时/计划功能在Java应用的各个领域都使用得非常多，比方说Web层面，可能一个项目要定时采集话单、定时更新某些缓存、
	 * 	 定时清理一批不活跃用户等等。定时计划任务功能在Java中主要使用的就是Timer对象，它在内部使用多线程方式进行处理，异步的
	 *   所以它和多线程技术关联还是相当大的。
	 * 2.Timer的schedule(TimeTask task, Date time)的使用
	 * 		<1>在time时间点执行一次任务，执行完线程没有结束，需要在将timer对象设为守护线程。
	 * 		<2>如果执行时间比当前时间早，那么会立即执行。
	 * 		<3>多个TimerTask，Task是以队列的方式一个一个被顺序执行的，所以执行的时间有可能和预期的时间不一致，
	 * 			因为前面的任务可能消耗过长，后面任务的运行时间也有可能被延迟。
	 * 3.Timer的schedule(TimerTask task, Date firstTime, long period)
	 * 		<1>在firstTime开始每period段时间执行一次。
	 * 		
	 * 4.TimerTask的cancel()方法
	 * 		<1>用于将自己从任务队列中清除。
	 * 		
	 * 5.Timer的cancel()方法
	 * 		<1>取消队列中所有的任务。
	 * 		<2>因为cancel()方法会尝试去获取queue锁，如果并没有获取到queue锁的话，TimerTask类中的任务继续执行也
	 * 		   是完全有可能的。
	 * 
	 * 6.其他方法
	 * 		Timer.schedule(TimerTask task,long delay);
	 * 		Timer.schedule(TimerTask task,long delay,long period);
	 * 		Timer.scheduleAtFixedRate(TimerTask task, Date firstTime, long period)
	 */
	
	private static Timer timer = new Timer();
	private static Timer timer2 = new Timer(true);
	
	public static class MyTask extends TimerTask{

		@Override
		public void run() {
			System.out.println("运行了，时间为：" + new Date());
		}
		
	}
	public static class MyTask2 extends TimerTask{
		
		@Override
		public void run() {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("运行了，时间为：" + new Date());
		}
		
	}

	public static void main(String[] args) throws ParseException {
		MyTask myTask = new MyTask();
		MyTask2 myTask2 = new MyTask2();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = "2018-7-10 01:32:00";
		String dateStr2 = "2018-7-10 01:32:00";
		Date time = format.parse(dateStr);
		Date time2 = format.parse(dateStr2);
		System.out.println("计划执行时间：" + time.toLocaleString() + ", 当前时间：" + new Date() );
		System.out.println("计划执行时间：" + time2.toLocaleString() + ", 当前时间：" + new Date() );
//		timer2.schedule(myTask2, time2);
//		timer2.schedule(myTask, time);		//Timer中有一个队列，所以任务是会阻塞的
		
		timer2.schedule(myTask, time);
		
		myTask.cancel();
		
		System.out.println("这是异步的吗？");
	}

}
