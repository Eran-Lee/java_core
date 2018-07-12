package com.eran.thread.thread_ReentranReadWriteLock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDomain extends ReentrantReadWriteLock {

	private static final long serialVersionUID = 1L;

	public void read() {
		try {
			readLock().lock();
			System.out.println(Thread.currentThread().getName() + "获得了读锁，时间为" + System.currentTimeMillis());
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			readLock().unlock();
		}
	}
	
	public void write() {
		try {
			writeLock().lock();
			System.out.println(Thread.currentThread().getName() + "获得了写锁，时间为" + System.currentTimeMillis());
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			writeLock().unlock();
		}
	}

}
