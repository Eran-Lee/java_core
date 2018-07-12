package com.eran.thread.thread_tool_CyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class Test {
	
	/*
	 * CyclicBarrier
	 * 
	 * 1.CyclicBarrier从字面理解是指循环屏障，它可以协同多个线程，让多个线程在这个屏障前等待，
	 * 	 直到所有线程都达到了这个屏障时，再一起继续执行后面的动作。
	 * 
	 */
	
	public static void main(String[] args) {
		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				System.out.println("所有线程结束了，我才运行，当前时间" + System.currentTimeMillis());
			}
		};
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, runnable);
		CyclicBarrierThread cyclicBarrierThread1 = new CyclicBarrierThread(cyclicBarrier, 1);
		CyclicBarrierThread cyclicBarrierThread2 = new CyclicBarrierThread(cyclicBarrier, 2);
		CyclicBarrierThread cyclicBarrierThread3 = new CyclicBarrierThread(cyclicBarrier, 3);
		
		cyclicBarrierThread1.start();
		cyclicBarrierThread2.start();
		cyclicBarrierThread3.start();
	}
}
