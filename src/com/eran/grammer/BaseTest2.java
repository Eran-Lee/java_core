package com.eran.grammer;

import java.util.Random;

public class BaseTest2 {

	public static void main(String[] args) {
		String a = "hello";
		String b = "hello";
		String c = "hel" + "lo";	//编译期间完成
		System.out.println(a == b);
		System.out.println(a == c);
		
		String d = "hel";
		String e = "lo";
		String f = d + e;	//运行期间完成
		System.out.println(a == f);
		System.out.println(a == f.intern());
		
		String str1 = "a" + "b";
		String str2 = "ab";
		System.out.println(str1 == str2);
		String str3 = "a";
		String str4 = "b";
		String str6 = str3 + str4 ;
		System.out.println(str6 == str2);
		final String str7 = "a";
		final String str8 = "b";
		String str9 = str7 + str8;
		System.out.println(str2 == str9);
		String s1 = new String("123");
		String s2 = "123";
		System.out.println(s1 == s2);
		
		Random random = new Random();
		for(int i=0;i<10;i++) {
			System.out.print(random.nextInt(21) + "*");
			
		}
		System.out.println();
		for(int i=0;i<10;i++) {
			System.out.print((int)(Math.random()*11 + 10) + "*");
		}
		
		System.out.println("调用方法时原生数据交换问题");
		int t = 1;
		int p = 4;
		System.out.println("交换前：t:" + t + " p:" + p);
		change(t, p);
		System.out.println("交换前：t:" + t + " p:" + p);
		System.out.println("原生数据交换问题");
		Integer m = 1;
		Integer n = 4;
		System.out.println("交换前：m:" + m + " n:" + n);
		change(m, n);
		System.out.println("交换前：m:" + m + " n:" + n);
		
		for(int i=0;i<args.length;i++) {
			System.out.println(args[i]);
		}
	
    }
	
	//两个原生类型数据交换问题
	private static void change(int a, int b) {
		int temp = 0;
		temp = a;
		b = a;
		a = temp;
	}
	//两个原生类型数据交换问题
	private static void change(Integer a, Integer b) {
		Integer temp = 0;
		temp = a;
		b = a;
		a = temp;
	}
}
