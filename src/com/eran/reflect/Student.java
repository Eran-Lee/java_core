package com.eran.reflect;

public class Student {
	private String name;
	
	private Integer age;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	
	public String getInfo() {
		return name + ":" + age;
	}

}
