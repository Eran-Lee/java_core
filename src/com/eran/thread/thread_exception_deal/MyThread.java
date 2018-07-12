package com.eran.thread.thread_exception_deal;

public class MyThread extends Thread{
	
	@Override
	public void run() {
		String username = null;
		System.out.println(username.hashCode());
	}

}
