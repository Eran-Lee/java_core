package com.eran.thread.thread_tool_CountDownLatch;

import java.util.concurrent.CountDownLatch;

public class DoneThread extends Thread{
	private CountDownLatch latch;
	
	public DoneThread(CountDownLatch latch,String name) {
		super(name);
		this.latch = latch;
	}
	
	@Override
	public void run() {
		super.run();
		try
        {
            System.out.println(this.getName() + "要等待了，时间为" + System.currentTimeMillis());
            latch.await();
            System.out.println(this.getName() + "完待完成了，时间为" + System.currentTimeMillis());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
	}
}
