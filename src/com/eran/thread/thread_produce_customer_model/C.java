package com.eran.thread.thread_produce_customer_model;

public class C {
	private MyStack stack;
	
	public C (MyStack stack) {
		this.stack = stack;
	}
	
	public void popService() {
		stack.pop();
	}

}
