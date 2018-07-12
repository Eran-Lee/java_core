package com.eran.thread.qiangpiaomoni01;

public class Thread1 {
	
	public static void main(String[] args) {
		/*
		 * java 启动线程的方式
		 * 1.继承Thread类，重写run()方法，直接new出线程对象，调用start()方法启动线程，但是这种线程只能启动一次，
		 * 	达不到资源竞争的效果(可以用Thread在包一下，创建多个线程也可以达到资源竞争的效果)。
		 * 2.实现Runnable接口，创建Runnable对象，用Thread类对Runnable进行包装，可以实现资源竞争的效果，推荐；
		 * 3.直接在函数体使用（匿名内部类，其实也是属于第二种实现方式的特例。）
		 */
		System.out.println("*********例1**********");
		//多线程抢票例子的几种实现，有失败的例子，比如3
		//1.创建同一个资源
		//SellTicketSystem sellTicketSystem = new SellTicketSystem();
		
		//2.同一个资源引出连个通道给两个用户
		//Thread jack = new Thread(sellTicketSystem, "jack");
		//Thread rose = new Thread(sellTicketSystem, "rose");
		
		//jack.start();
		//rose.start();
		
		System.out.println("********例2***********");
//		SellTicketSystem2 sellTicketSystem2 = new SellTicketSystem2();
//		Thread tom = new Thread(sellTicketSystem2, "tom");
//		Thread marry = new Thread(sellTicketSystem2, "marry");
//		tom.start();
//		marry.start();
		
		System.out.println("*********例3**********");
//线程之间的资源如何共享、同步，感觉这种情况更有意义。
//		Integer total = 0;
//		Integer retain = 10;
//		Boolean  flag = true;
//		
//		SellTicketSystem3 t1 = new SellTicketSystem3(total, retain, flag);
//		SellTicketSystem3 t2 = new SellTicketSystem3(total, retain, flag);
//		SellTicketSystem3 t3 = new SellTicketSystem3(total, retain, flag);
//		
//		t1.start();
//		t2.start();
//		t3.start();
		
	}

}
