package com.eran.thread.syn_error;

public class Syn_Error_Test {
	public static void main(String[] args) {
		//1.同步出现的脏读问题；
		MyList myList = new MyList();
		MyThread1 myThread1 = new MyThread1(myList);
		MyThread2 myThread2 = new MyThread2(myList);
		
		myThread1.start();
		myThread2.start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("list 的大小：" + myList.getSize());
	}

}
