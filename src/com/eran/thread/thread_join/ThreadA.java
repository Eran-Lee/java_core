package com.eran.thread.thread_join;

public class ThreadA extends Thread{
	private ThreadB threadB;
	
	public ThreadA(ThreadB threadB) {
		this.threadB = threadB;
	}
	
	@Override
	 public void run() {
		synchronized (threadB) {
			System.out.println("A begin: " + System.currentTimeMillis());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("A end: " + System.currentTimeMillis());
		}
	}

}
