package com.eran.thread.syn_tongbusuo;

public class CoreResource {
	    public void doLongTimeTask() throws Exception
	    {
	        for (int i = 0; i < 100; i++)
	        {
	            System.out.println("nosynchronized threadName = " + 
	                    Thread.currentThread().getName() + ", i = " + (i + 1));
	        }
	        System.out.println();
	        synchronized (this)
	        {
	            for (int i = 0; i < 100; i++)
	            {
	                System.out.println("synchronized threadName = " + 
	                        Thread.currentThread().getName() + ", i = " + (i + 1));
	            }
	        }
	    }
	    
	    public void methodA() {
	    	synchronized (this) {
				for(int i=0;i<50;i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
	    }
	    
	    public void methodB() {
	    	synchronized (this) {
				for(int i=0;i<50;i++) {
					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}
	    }
}
