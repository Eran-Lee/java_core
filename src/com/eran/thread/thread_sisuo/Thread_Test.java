package com.eran.thread.thread_sisuo;

public class Thread_Test {
	/*
	 * 死锁
	 * 1.当一个线程永远地持有一个锁，并且其他线程都尝试去获得这个锁时，那么它们将永远被阻塞，这个我们都知道。如果线程A持有锁L并且想获得锁M，
	 * 	 线程B持有锁M并且想获得锁L，那么这两个线程将永远等待下去，这种情况就是最简单的死锁形式。
	 * 2.在数据库系统的设计中考虑了监测死锁以及从死锁中恢复，数据库如果监测到了一组事物发生了死锁时，将选择一个牺牲者并放弃这个事物。Java
	 * 	 虚拟机解决死锁问题方面并没有数据库这么强大，当一组Java线程发生死锁时，这两个线程就永远不能再使用了，并且由于两个线程分别持有了
	 * 	 两个锁，那么这两段同步代码/代码块也无法再运行了----除非终止并重启应用。
	 * 3.要学jdk/bin目下的工具使用
	 * 4.避免死锁的方法
			1、让程序每次至多只能获得一个锁。当然，在多线程环境下，这种情况通常并不现实
			2、设计时考虑清楚锁的顺序，尽量减少嵌在的加锁交互数量
			3、既然死锁的产生是两个线程无限等待对方持有的锁，那么只要等待时间有个上限不就好了。
			   当然synchronized不具备这个功能，但是我们可以使用Lock类中的tryLock方法去尝试获取锁，
			   这个方法可以指定一个超时时限，在等待超过该时限之后变回返回一个失败信息
	 */

	public static void main(String[] args) {
		DeadLock deadLock = new DeadLock();
		MyThread01 myThread01 = new MyThread01(deadLock);
		MyThread02 myThread02 = new MyThread02(deadLock);
		myThread01.start();
		myThread02.start();
		
	}

}
