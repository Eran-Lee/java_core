package com.eran.thread.thread_cas;

public class Thread_Test {

	public static void main(String[] args) {
		/*
		 * 1.java中无锁CAS主题
		 * 		<1>背景：大量的加锁同步，导致额外锁的开销、线程的调度等使得程序的伸缩性下降，于是在一些不是很有必要的情况下，使用
		 * 				无锁的方式实现，效率会更高。这些无锁的方法都利用了处理器提供的CAS(compare and switch)指令。
		 * 		<2>什么是CAS呢？CAS算法是一种更新机制，过程是原子的，它是由一条CPU指令完成的。在java中实现CAS的类也必定是一个原子性
		 * 			的操作，可以在java代码看到源码，cas的实现过程是navite，直接调用本地脚本处理的 cmpxchg，所以是原子的，不必担心线程安全。
		 * 		<3>java当中提供了很多无锁类，也就是底层用到了CAS类。
		 * 			1）AtomicInteger: AtomicInteger和Integer一样，都继承与Number类,AtomicInteger里面有很多CAS操作.
		 * 			   当然还有AtomicBoolean，AtomicLong等等，都大同小异。
		 * 			2) Unsafe: 从类名就可知，Unsafe操作是非安全的操作,上面中的方法就用到这个方法。
		 * 			3）AtomicReference : AtomicReference是一种模板类。
		 * 			4）AtomicStampedReference： 这个类的主要思想是加入时间戳来标识每一次改变。
		 * 			5）AtomicIntegerArray：与AtomicInteger相比，数组的实现不过是多了一个下标。
		 * 			6）AtomicIntegerFieldUpdater：AtomicIntegerFieldUpdater类的主要作用是让普通变量也享受原子操作。


		 * 		
		 */
	}

}
