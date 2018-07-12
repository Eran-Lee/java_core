package com.eran.thread.thread_tool_Exchanger;

import java.util.concurrent.Exchanger;

public class ExchangerThread extends Thread{
	private String str;
	private Exchanger<String> exchanger;
	private int sleepSecond;
	
	public ExchangerThread(String str, Exchanger<String> exchanger,int sleepSecond){
		this.str = str;
		this.exchanger = exchanger;
		this.sleepSecond = sleepSecond;
	}
	
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + "线程启动，原数据为" + str + ",时间为" + System.currentTimeMillis());
			Thread.sleep(1000 * sleepSecond);
			str = exchanger.exchange(str);
			System.out.println(Thread.currentThread().getName() + "交换了数据，交换后的数据为" + str + ",时间为" + System.currentTimeMillis());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
