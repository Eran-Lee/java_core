package com.eran.thread.thread_tool_CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread extends Thread{
	private CyclicBarrier barrier;
	private int sleepSecond;
	
	public CyclicBarrierThread(CyclicBarrier barrier,int sleepSecond) {
		this.barrier = barrier;
		this.sleepSecond = sleepSecond;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(this.getName() + "线程运行了");
			Thread.sleep(sleepSecond*1000);
			System.out.println(this.getName() + "开始等待了，时间为" + System.currentTimeMillis());
				barrier.await();
			System.out.println(this.getName() + "等待结束，时间为" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(BrokenBarrierException e) {
			
		}
	}

}
