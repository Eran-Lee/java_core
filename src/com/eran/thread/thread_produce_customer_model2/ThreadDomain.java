package com.eran.thread.thread_produce_customer_model2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDomain extends ReentrantLock{
	
	private Condition condition = newCondition();
	
	public void set() {
		try {
			lock();
			while(!"".equals(ValueObject.value)) {
				condition.await();
			}
			ValueObject.value = "123";
			System.out.println(Thread.currentThread().getName() + "线程生产了数据，数据为：" + ValueObject.value);
			condition.signal();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			unlock();
		}
	}
	
	
	public void get() {
		try {
			lock();
			while("".equals(ValueObject.value)) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "线程消费了，数据为：" + ValueObject.value);
			ValueObject.value = "";
			condition.signal();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			unlock();
		}
	}

}
