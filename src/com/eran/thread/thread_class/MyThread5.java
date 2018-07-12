package com.eran.thread.thread_class;

public class MyThread5 extends Thread {

	@Override
	public void run() {
		super.run();
		try {
			for (int i = 0; i < 500000; i++) {
				if (this.interrupted()) {
					System.out.println("should be stopped and exit");
					// break;	//优雅退出，导致不能立即退出，这里换成了抛出异常。
					throw new InterruptedException();

				}
				System.out.println("i=" + (i + 1));
			}
			System.out.println("this line is also executed. thread does not stopped");// 尽管线程被中断,但并没有结束运行。这行代码还是会被执行
		} catch (InterruptedException e) {
			 Thread.currentThread().interrupt();//这样处理比较好
		}
	}
}
