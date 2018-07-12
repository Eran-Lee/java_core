package com.eran.thread.syn_tongbusuo;

public class MyThread3 extends Thread{
	private CoreResource coreResource;

	public MyThread3(CoreResource coreResource) {
		super();
		this.coreResource = coreResource;
	}
	
	@Override
	public void run() {
		try {
			coreResource.methodB();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
