package com.eran.thread.syn_error2;

public class Syn_Error_Test {
	public static void main(String[] args) {
			ThreadDomain threadDomain = new ThreadDomain();
			MyThread01 myThread01 = new MyThread01(threadDomain);
			MyThread02 myThread02 = new MyThread02(threadDomain);
			
			myThread01.start();
			myThread02.start();
			/*
			 * 输出
a set over!
b set over!
b num = 200
a num = 200	//你睡大觉过程中，别的线程改动了值。修改方法就是增加synchronized
			 */
			
		
	}

}
