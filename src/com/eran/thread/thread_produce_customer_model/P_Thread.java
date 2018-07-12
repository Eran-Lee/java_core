package com.eran.thread.thread_produce_customer_model;

public class P_Thread extends Thread{
	private P p;
	
	public P_Thread(P p) {
		this.p = p;
	}
	
	@Override
	public void run() {
		while(true) {
			p.pushService();
		}
	}
}
