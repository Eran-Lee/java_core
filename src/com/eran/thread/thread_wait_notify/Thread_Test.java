package com.eran.thread.thread_wait_notify;

	/*
	 * wait()/notify()/notifyAll()方法
	 * 1.线程之间是要通信的，例如轮询检查的代价就没有主动通知好。
	 * 2.在Object对象中有三个方法wait()、notify()、notifyAll()，既然是Object中的方法，
	 * 	 那每个对象自然都是有的。如果不接触多线程的话，这两个方法是不太常见的。
	 * 3.wait(): wait()的作用是使当前执行代码的线程进行等待，将当前线程置入"预执行队列"中，
	 * 	 		 并且wait()所在的代码处停止执行，直到接到通知或被中断。在调用wait()之前，线程必须获得该对象的锁，
	 *   		 因此只能在同步方法/同步代码块中调用wait()方法，然后wait会放掉当前锁。
	 * 4.notify(): notify()的作用是，如果有多个线程等待，那么线程规划器随机挑选出一个wait的线程，对其发出通知notify()，
	 * 			   并使它等待获取该对象的对象锁。注意"等待获取该对象的对象锁"，这意味着，即使收到了通知，wait的线程也不
	 * 			会马上获取对象锁, 必须等待notify()方法的线程释放锁才可以。和wait()一样，notify()也要在同步方法/同步代码块中调用。
	 * 			notify()调用一次则只会唤醒一个线程，执行多次会唤醒全部wait该对象的锁。
	 * 5.两者关系
	 * 		wait()使线程停止运行，notify()使停止运行的线程继续运行。
	 * 		而且是在相同的对象锁上才能互相通知,调用等待/通知的对象必须是上锁的对象，否则根本不存在联系，自然无法等待/通知,
	 * 		如果下面两点都没有满足，则抛出java.lang.IllegalMonitorStateException
	 * 			1.必须有被锁的对象
				2.必须是被锁的对象wait/notify
		
		6.interrupt(): 处于blocked状态的线程，可以利用该方法使阻塞中断，即sleep(),wait()都是可以被打断的。
	 */
public class Thread_Test {
	public static void main(String[] args) throws InterruptedException {
		Object object = new Object();
		MyThread01 myThread01 = new MyThread01(object);
		myThread01.start();
		Thread.sleep(2000);
		MyThread02 myThread02 = new MyThread02(object);
		myThread02.start();
	}

}
