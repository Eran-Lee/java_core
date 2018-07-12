package com.eran.thread.syn_error;

public class MyService {
	public MyList addServiceMethod(MyList list, String a) {
		synchronized (list) {   //哪里容易出现同步问题，那你就上锁，这里就是容易出现同步问题！！！！锁就是公共资源对象最好。
			if (list.getSize() < 1) {
				try {
					Thread.sleep(6000);
					list.add(a);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return list;
	}
}
