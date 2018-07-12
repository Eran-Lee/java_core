package com.eran.thread.thread_group;

public class ThreadDomain extends Thread{
	
	public ThreadDomain(ThreadGroup tg, String name) {
		super(tg, name);
	}
	
	@Override
	public void run() {
		System.out.println("线程" + Thread.currentThread().getName() +  "：准备死循环");
		while(!this.isInterrupted()) {}
		System.out.println("线程" + Thread.currentThread().getName() +  "：跳出了死循环");
	}

}
