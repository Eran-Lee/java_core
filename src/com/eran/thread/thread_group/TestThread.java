package com.eran.thread.thread_group;

public class TestThread {
	/*
	 * 线程组
	 * 1.可以把线程归属到某一个线程组中，线程组中可以有线程对象，也可以有线程组，组中还可以有线程，这样的组织结构有点类似于树的形式。
	 * 2.线程组的作用是：可以批量管理线程或线程组对象，有效地对线程或线程组对象进行组织。
	 * 3.一级关联：所谓1级关联就是父对象中有子对象，但并不创建孙对象。这种情况在开发中很常见。
	 * 4.线程关联线程组:ThreadGroup(ThreadGroup parent, String name)。
	 * 5.线程自动归属特性。threadGroup.enumerate(线程数组)：拷贝线程数组threadGroup到线程数组中。
	 * 6.线程内加线程数组。在main方法中创建线程组，默认父线程组是main。
	 * 7.根线程组是system。
	 * 8.批量阻止组内线程。
	 * 9.递归与非递归获得组内对象：Thread.currentThread().getThreadGroup().enumerate(threadGroups2, false);
	 * 		
	 * 
	 */

	public static void main(String[] args) {
		//线程组
//		MyThread myThread = new MyThread();
//		MyThread myThread2 = new MyThread();
//		ThreadGroup threadGroup = new ThreadGroup("线程组1");
//		Thread thread = new Thread(threadGroup, myThread, "线程1");
//		Thread thread2 = new Thread(threadGroup, myThread2, "线程2");
//		
//		thread.start();
//		thread2.start();
//		
//		System.out.println("活动的线程个数为：" + threadGroup.activeCount());
//		System.out.println("线程组名为：" + threadGroup.getName());
//		System.out.println("父线程组名：" + threadGroup.getParent().getName());
		
		//线程组内加线程组
//		System.out.println("线程组名称：" + Thread.currentThread().getThreadGroup().getName());
//		System.out.println("线程组内活动的线程个数：" + Thread.currentThread().getThreadGroup().activeCount());
//		System.out.println("线程组内活动的线程组个数,增加前：" + Thread.currentThread().getThreadGroup().activeGroupCount());
//		ThreadGroup threadGroup2 = new ThreadGroup(Thread.currentThread().getThreadGroup(), "新增线程组");
//		System.out.println("线程组内活动的线程组个数，增加后：" + Thread.currentThread().getThreadGroup().activeGroupCount());
//		System.out.println("父线程组名：" + Thread.currentThread().getThreadGroup().getParent().getName());
		
		//线程组批量操作
//		ThreadGroup tg = new ThreadGroup("组1");
//		for(int i=0;i<3;i++) {
//			new ThreadDomain(tg, i + "1").start();
//		}
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		tg.interrupt();
		
		//递归与非递归获得组内对象
		ThreadGroup groupMain = Thread.currentThread().getThreadGroup();
		ThreadGroup AG = new ThreadGroup(groupMain, "A");
		ThreadGroup BG = new ThreadGroup(AG, "B");
		ThreadGroup[] threadGroups = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadGroups, true);
		for(int i=0;i<threadGroups.length;i++) {
			if(threadGroups[i] != null) {
				System.out.println(threadGroups[i].getName());
			}
		}
		System.out.println("***");
		ThreadGroup[] threadGroups2 = new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		Thread.currentThread().getThreadGroup().enumerate(threadGroups2, false);
		for(int i=0;i<threadGroups2.length;i++) {
			if(threadGroups2[i] != null) {
				System.out.println(threadGroups2[i].getName());
			}
		}

	}

}
