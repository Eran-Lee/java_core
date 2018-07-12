package com.eran.thread.syn_tongbusuo;

public class MyThread2 extends Thread{
	private CoreResource coreResource;

	public MyThread2(CoreResource coreResource) {
		super();
		this.coreResource = coreResource;
	}
	
	@Override
	public void run() {
		try {
			coreResource.methodA();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
