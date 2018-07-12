package com.eran.thread.syn_error2;

public class MyThread02 extends Thread{
	private ThreadDomain threadDomain;

	public MyThread02(ThreadDomain th) {
		this.threadDomain = th;
	}
	
	@Override
	public void run() {
		threadDomain.addNum("b");
	}
}
