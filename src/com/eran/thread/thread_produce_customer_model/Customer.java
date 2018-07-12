package com.eran.thread.thread_produce_customer_model;

public class Customer {
	private Object lock;
	
	public Customer(Object lock) {
		this.lock = lock;
	}
	
	public void getValue() {
		
		synchronized (lock) {
			while(ValueObject.value.equals("")) {	//这里用while比较好。if还是会出问题的。
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("GET的值：" + ValueObject.value);
			ValueObject.value = "";
			lock.notify();
		}
	}
}
