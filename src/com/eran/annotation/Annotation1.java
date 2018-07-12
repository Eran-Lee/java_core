package com.eran.annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SelfAnnotation
public class Annotation1 {
	
	public static void main(String[] args) {
		
		/********测试自定义的注解*********/
		boolean annotationPresent = Annotation1.class.isAnnotationPresent(SelfAnnotation.class);
		
		if(annotationPresent){
			SelfAnnotation annotation = Annotation1.class.getAnnotation(SelfAnnotation.class);
			System.out.println(annotation.annotationType());
			System.out.println(annotation.id());
			System.out.println(annotation.msg());
			
		}
		System.out.println("---------------------------------------------");
		/********通过注解来完成对某个类的方法是否会产生异常进行测试（简单的测试框架）*********/
		NoBug noBug = new NoBug();
		Method[] methods = NoBug.class.getDeclaredMethods();
		StringBuffer res = new StringBuffer();
		for(int i=0;i<methods.length;i++) {
			if(methods[i].isAnnotationPresent(SelfAnnotation.class)) {
				try {
					methods[i].setAccessible(true);
					methods[i].invoke(noBug);
				} catch (Exception e) {
					res.append(methods[i].getName() + "出现异常，异常类型为：" + e.getCause() + "\n"); 
					
				} 
			}
		}
		System.out.println(res);
	}
}
