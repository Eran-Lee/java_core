package com.eran.annotation;

public class NoBug {
	
	@SelfAnnotation
	public void testAdd() {
		System.out.println("我是加法");
	}

	@SelfAnnotation
	public void testSub() {
		System.out.println("我是减法");
	}
	
	@SelfAnnotation
	public void testchengfa() {
		System.out.println("我是乘法");
	}
	
	@SelfAnnotation
	@SuppressWarnings("unused")
	private void testchufa() {
		System.out.println(10/0);
	}
	
	@SelfAnnotation
	private void testnullpoint() {
		String a = null;
		System.out.println(a.length());
	}
}
