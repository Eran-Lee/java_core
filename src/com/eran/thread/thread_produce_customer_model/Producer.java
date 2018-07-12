package com.eran.thread.thread_produce_customer_model;

public class Producer {
	private Object lock;
	
	public Producer(Object lock) {
		this.lock = lock;
	}
	
	public void setValue() {
		
		synchronized (lock) {
			while(!ValueObject.value.equals("")) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			String  value = System.currentTimeMillis() + "_" + System.nanoTime();
			System.out.println("SET的值：" + value);
			ValueObject.value = value;
			lock.notify();
			
		}
	}

}
