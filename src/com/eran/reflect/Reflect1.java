package com.eran.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;

public class Reflect1 {
	
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//      Class<?> clazz = Class.forName("com.eran.reflect.Student"); //必须是完全限定名
//		Class<?> clazz = Class.forName("java.lang.Integer"); //不行
		Class<?> clazz = Integer.class;
		
		/*
		Field[] fields = clazz.getDeclaredFields();
		System.out.println(fields.length);
		
		
		
		Class<?> superclass = clazz.getSuperclass();
		System.out.println(superclass.getName());
		
		Class<?> superclass2 = superclass.getSuperclass();
		System.out.println(superclass2.getName());
		
		Class<?>[] interfaces = clazz.getInterfaces();
		for(int i=0;i<interfaces.length;i++) {
			System.out.println(interfaces[i].getName());
		}
		*/
		/*************************构造方法****************************/
		Constructor<?>[] constructors = clazz.getConstructors();
		System.out.println(constructors.length);
		for(int i=0;i<constructors.length;i++) {
			Parameter[] parameters = constructors[i].getParameters();
			StringBuffer msg = new StringBuffer();
			for(int j=0;j<parameters.length;j++) {
				msg.append("<" + parameters[j].getType() + "," + parameters[j].getName() + ">");
			}
			System.out.println("构造方法：" + constructors[i].getName() + "的参数：" + msg);
		}
		
		Constructor<?> constructor = constructors[1];
		Object newInstance = constructor.newInstance("123");
		System.out.println(newInstance.toString());
		
		
		/*************************成员方法****************************/

		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(methods.length);
		for(int i=0;i<methods.length;i++) {
			Parameter[] parameters = methods[i].getParameters();
			StringBuffer msg = new StringBuffer();
			for(int j=0;j<parameters.length;j++) {
				msg.append("<" + parameters[j].getType() + "," + parameters[j].getName() + ">");
			}
			System.out.println("方法" + methods[i].getName() + ":" + msg + "****"  + methods[i].getParameterTypes() + "***" + Modifier.isStatic(methods[i].getModifiers()));
		}
		
		//一、静态方法
		Method method = clazz.getMethod("sum", int.class,int.class);
		//静态方法的调用方式1
		Object res = method.invoke(newInstance, 12,21);
		System.out.println(res.toString());
		
		//静态方法调用2
		Object res2 = method.invoke(null, 12,1);
		System.out.println(res2);
			
		//二、非静态方法
		Method method2 = clazz.getMethod("compareTo", Integer.class);
//		Object invoke = method2.invoke(null, 12);  //fail
		Object invoke = method2.invoke(newInstance, 123);
		System.out.println(invoke.toString());
		
		/*************************通过反射了解泛型的本质*****************************/
		ArrayList list1 =new ArrayList();
		ArrayList<String> list2 =new ArrayList<String>();
		Class c1 = list1.getClass();
		Class c2 = list2.getClass();
		System.out.println(c1==c2); //泛型在编译后，类型擦除
		
		/*
		 * 1.类的加载过程
		 * 2.类的加载时机
		 * 3.类加载器的分类
		 */
		
		
	}
}
