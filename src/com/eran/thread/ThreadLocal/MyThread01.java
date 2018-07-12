package com.eran.thread.ThreadLocal;

public class MyThread01 extends Thread{
	
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(Thread.currentThread().getName() + "线程中的变量：" + Tool.t1.get());
		}
	}

}
