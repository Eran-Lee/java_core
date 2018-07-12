package com.eran.thread.thread_tool_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class WorkThread extends Thread{
	private CountDownLatch latch;
	private int sleepSecond;
	
	public WorkThread(CountDownLatch latch,int sleepSecond,String name) {
		super(name);
		this.latch = latch;
		this.sleepSecond = sleepSecond;
	}
	
	@Override
	public void run() {
		super.run();
		try
        {
            System.out.println(this.getName() + "启动了，时间为" + System.currentTimeMillis());
            Thread.sleep(sleepSecond * 1000);
            latch.countDown();
            System.out.println(this.getName() + "执行完了，时间为" + System.currentTimeMillis());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
	}
}
