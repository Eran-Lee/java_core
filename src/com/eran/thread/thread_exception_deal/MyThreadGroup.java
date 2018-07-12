package com.eran.thread.thread_exception_deal;

public class MyThreadGroup extends ThreadGroup{

	public MyThreadGroup(String name) {
		super(name);
	}
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		super.uncaughtException(t, e);
		System.out.println(t.getThreadGroup().getName() + "组出现错误");
		this.interrupt();
	}

}
