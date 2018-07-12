package com.eran.thread.qiangpiaomoni01;

public class SellTicketSystem implements Runnable {
	private int total = 0;
	private int retain = 100;

	boolean flag = true;

	@Override
	public void run() {
		while (flag) {
			synchronized (this) {
				if (retain < 1) {
					flag = false;
					return;
				}

				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // 模拟网络延迟3秒

				retain--;
				total++;
				System.out.println(Thread.currentThread().getName() + ":出票数：" + total + ", 剩余：" + retain);
			}
		}
	}

}
