package com.eran.thread.ThreadLocal;

public class MyThreadLocal {

	private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {
		
		@Override
		protected Object initialValue() {
			System.out.println(Thread.currentThread().getName() +  ":调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
			return null;
		};
	};
	
	public static class MyIntegerTask implements Runnable{
		
		private String name;
		
		public MyIntegerTask(String name) {
			this.name = name;
		}
		
		@Override
		public void run() {
			for(int i=0;i<5;i++) {
				if(null == MyThreadLocal.threadLocal.get()) {
					MyThreadLocal.threadLocal.set(0);
					System.out.println("线程" + name + " :0");
				}else {
					Integer num = (Integer)MyThreadLocal.threadLocal.get();
					MyThreadLocal.threadLocal.set(num + 1);
					System.out.println("线程" + name + " :" + MyThreadLocal.threadLocal.get());
					if(i==3) {
						MyThreadLocal.threadLocal.remove();
					}
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};
	
	public static class MyStringTask implements Runnable{
		private String name;
		
		public MyStringTask(String name) {
			this.name = name;
		}

		@Override
		public void run() {
			for(int i=0;i<5;i++) {
				if(null == MyThreadLocal.threadLocal.get()) {
					MyThreadLocal.threadLocal.set("a");
					System.out.println("线程" + name + " : a");
				}else {
					String str = (String)MyThreadLocal.threadLocal.get();
					MyThreadLocal.threadLocal.set(str + "a");
					System.out.println("线程" + name + ":" + MyThreadLocal.threadLocal.get());
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
	
	public static void main(String[] args) {
		new Thread(new MyIntegerTask("thread_int1")).start();
		new Thread(new MyStringTask("thread_string1")).start();
		new Thread(new MyIntegerTask("thread_int2")).start();
		new Thread(new MyStringTask("thread_string2")).start();
		
	}


	
	
}
