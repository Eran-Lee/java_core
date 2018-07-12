package com.eran.thread.ThreadLocal;

public class TestThread {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * ThreadLocal
		 * 	1.什么是ThreadLocal？使用目的是什么？
		 * 		<1>ThreadLocal 是线程的局部变量， 是每一个线程所单独持有的，其他线程不能对其进行访问， 
		 * 			通常是类中被 private static 字段修饰。
		 * 		<2>我们知道有时候一个对象的变量会被多个线程所访问，这时就会有线程安全问题，当然我们可以
		 * 			使用synchorinized 关键字来为此变量加锁，进行同步处理，从而限制只能有一个线程来使用此
		 * 			变量，但是加锁会大大影响程序执行效率，此外我们还可以使用ThreadLocal来解决对某一个变量的
		 * 			访问冲突问题。这就是用空间换时间的策略。
		 * 
		 * 
		 * 2.ThreadLocal 的几个方法： ThreadLocal 可以存储任何类型的变量对象， get返回的是一个Object对象，
		 * 	 但是我们可以通过泛型来制定存储对象的类型。
		 * 		public T get() { } // 用来获取ThreadLocal在当前线程中保存的变量副本
		 * 		public void set(T value) { } //set()用来设置当前线程中变量的副本
		 * 		public void remove() { } //remove()用来移除当前线程中变量的副本
		 * 		protected T initialValue() { } //initialValue()是一个protected方法，一般是用来在使用时进行重写的
		 * 
		 * 3.Thread 在内部是通过ThreadLocalMap来维护ThreadLocal变量表， 在Thread类中有一个threadLocals 变量，
		 * 	 是ThreadLocalMap类型的，它就是为每一个线程来存储自身的ThreadLocal变量的， ThreadLocalMap是ThreadLocal类
		 * 	 的一个内部类，这个Map里面的最小的存储单位是一个Entry， 它使用ThreadLocal作为key， 变量作为 value，
		 * 	 这是因为在每一个线程里面，可能存在着多个ThreadLocal变量.
		 * 
		 * 4.ThreadLocal的应用场景
		 * 		用来解决数据库连接，session管理等。
		 * 
		 * 5.关于ThreadLocalMap<ThreadLocal, Object>弱引用问题：
		 * 		<1>使用完线程共享变量后，显示调用ThreadLocalMap.remove方法清除线程共享变量。
		 * 		<2>JDK建议ThreadLocal定义为private static，这样ThreadLocal的弱引用问题则不存在了。
		 * 
		 * 6.InhertiedThreadLocal:可以在子线程中夺取父线程的变量，也可以在子类中添加子类自己的值。
		 * 		
		 */
		
		for(int i=0;i<10;i++) {
			System.out.println("在main中取值：" + Tool.t1.get());
			Thread.sleep(100);
		}
		MyThread01 myThread01 = new MyThread01();
		myThread01.setName("A");
		myThread01.start();
		
		
	}

}
