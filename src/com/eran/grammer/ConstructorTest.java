package com.eran.grammer;

public class ConstructorTest {
	private int num;
	private String name;
	{
		num = 3;
		System.out.println("构造代码块");
	}
	static {
		System.out.println("静态代码块");
	}
	
	public ConstructorTest() {
		System.out.println("我是默认构造方法" + ",num:" + num);
	}
	public ConstructorTest(int num, String name) {
		System.out.println("我是有参构造方法" + ",num:" + num);
		this.num = num;
		this.name = name;
	}

	public static void main(String[] args) {
		ConstructorTest constructorTest = new ConstructorTest();
		ConstructorTest constructorTest2 = new ConstructorTest(2, "赵四");
	}
}
