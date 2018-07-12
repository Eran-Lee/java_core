package com.eran.thread.thread_produce_customer_model;

public class P {
	private MyStack stack;
	
	public P (MyStack stack) {
		this.stack = stack;
	}
	
	public void pushService() {
		stack.push();
	}

}
