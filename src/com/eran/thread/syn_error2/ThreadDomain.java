package com.eran.thread.syn_error2;

public class ThreadDomain {
	private int num  = 0;
	
	 public void addNum(String userName)
	    {
	        try
	        {
	            if ("a".equals(userName))
	            {
	                num = 100;
	                System.out.println("a set over!");
	                Thread.sleep(2000);
	            }
	            else
	            {
	                num = 200;
	                System.out.println("b set over!");
	            }
	            System.out.println(userName + " num = " + num);
	        }
	        catch (InterruptedException e)
	        {
	            e.printStackTrace();
	        }
	    }
}
