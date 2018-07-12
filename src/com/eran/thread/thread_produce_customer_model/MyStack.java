package com.eran.thread.thread_produce_customer_model;

import java.util.ArrayList;
import java.util.List;

public class MyStack {
	private List list = new ArrayList<>();

	synchronized public void push() {
		try {
			if (list.size() > 0) {
				this.wait();
			}
			list.add("anyString=" + Math.random());
			System.out.println("push=" + list.size());
			this.notifyAll();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	synchronized public String pop() {
		String result = "";

		try {
			while (list.size() == 0) {
				System.out.println("pop方法中，缓存中没有数据,处于等待中，当前线程：" + Thread.currentThread().getName());
				this.wait();
			}
			result = (String)list.get(0);
			list.remove(0);
			this.notifyAll();
			System.out.println("pop方法中，取出了数据，当前线程：" + Thread.currentThread().getName());
//			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
