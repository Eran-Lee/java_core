package com.eran.exception;

public class Exception1 {

	public static void main(String[] args) {
		        int i = 0;  
		        String greetings[] = { " Hello world !", " Hello World !! ",  
		                " HELLO WORLD !!!" };  
		        while (i < 4) {  
		            try {  
		                // 特别注意循环控制变量i的设计，避免造成无限循环  
//		                System.out.println(greetings[i]);  i++;  //无限循环
		            	System.out.println(greetings[i++]);
		            } catch (ArrayIndexOutOfBoundsException e) {  
		                System.out.println("数组下标越界异常");  
		            } finally {  
		                System.out.println("--------------------------");  
		            }  
		        }  
	}

}
