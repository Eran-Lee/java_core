package com.eran.thread.syn_tongbusuo;

public class MyThread extends Thread{
	private CoreResource coreResource;

	public MyThread(CoreResource coreResource) {
		super();
		this.coreResource = coreResource;
	}
	
	@Override
	public void run() {
		try {
			coreResource.doLongTimeTask();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
