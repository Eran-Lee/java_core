package com.eran.thread.thread_tool_Exchanger;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class Test {
	/*
	 * Exchanger
	 * 
	 * 1.Exchanger用于在两个线程之间进行数据交换，注意也只能在两个线程之间进行数据交换。线程会阻塞在Exchanger的exchange方法上，
	 *   直到另外一个线程也到了同一个Exchanger的exchange方法时，二者进行数据交换，然后两个线程继续执行自身相关的代码。
	 */
	public static void main(String[] args) {
		Exchanger<String> exchanger = new Exchanger<String>();
		ExchangerThread exchangerThread1 = new ExchangerThread("线程1中的数据*香蕉", exchanger, 1);
		ExchangerThread exchangerThread2 = new ExchangerThread("线程1中的数据*苹果", exchanger, 2);
		exchangerThread1.start();
		exchangerThread2.start();
	}
	/*输出结果
	 *  Thread-0线程启动，原数据为线程1中的数据*香蕉,时间为1531323188243
		Thread-1线程启动，原数据为线程1中的数据*苹果,时间为1531323188243
		Thread-1交换了数据，交换后的数据为线程1中的数据*香蕉,时间为1531323190247
		Thread-0交换了数据，交换后的数据为线程1中的数据*苹果,时间为1531323190247
		
		结论：由于一个线程睡1秒，另一个2秒，但是为了同时交换，所以线程1必须等线程2，所以线程线程1运行完也是耗时2s.
	 */
}
