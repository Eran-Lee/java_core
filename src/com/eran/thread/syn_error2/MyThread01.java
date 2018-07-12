package com.eran.thread.syn_error2;

public class MyThread01 extends Thread{
	private ThreadDomain threadDomain;

	public MyThread01(ThreadDomain th) {
		this.threadDomain = th;
	}
	
	@Override
	public void run() {
		threadDomain.addNum("a");
	}
}
