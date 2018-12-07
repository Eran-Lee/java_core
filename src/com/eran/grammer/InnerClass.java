package com.eran.grammer;

class InnerClass {

	public static void main(String[] args) {
		InnerClass innerClass = new InnerClass();
		Cat cat = innerClass.new Cat("小黑");
		cat.miaomiao();
		cat.say(new CommonInterface() {
			
			@Override
			public void say() {
				System.out.println("我是用匿名内部类说的");
				
			}
		});
		
		
		
		
	}
	
	//1.普通内部类(成员内部类)
	//	a.内部类可以拥有private访问权限、protected访问权限、public访问权限及默认访问权限;而外部类则不能用private修饰。
		 
	public class Cat{
		private String name;
		public Cat() {
		}
		
		public Cat(String name) {
			this.name = name;
		}
		
		public void miaomiao() {
			System.out.println("我是小猫：" + name);
		}
		
		public void say(CommonInterface ci) {
			ci.say();
		}
	}
	
	static class Dog{
		
	}
	
	
	//2.局部内部类
	//局部内部类是定义在一个方法或者一个作用域里面的类，它和成员内部类的区别在于局部内部类的访问仅限于方法内或者该作用域内。
	//局部内部类就像是方法里面的一个局部变量一样，是不能有public、protected、private以及static修饰符的。只能用final、或abstract修饰
	
	//3.匿名内部类
	//3.1匿名内部类应该是平时我们编写代码时用得最多的，在编写事件监听的代码时使用匿名内部类不但方便，而且使代码更加容易维护。
	//3.2使用匿名内部类能够在实现父类或者接口中的方法情况下同时快速产生一个相应的对象，但是前提是这个父类或者接口必须先存在才能这样使用。
	//3.3匿名内部类是唯一一种没有构造器的类。正因为其没有构造器，所以匿名内部类的使用范围非常有限，大部分匿名内部类用于接口回调。
	//	 匿名内部类在编译的时候由系统自动起名为Outter$1.class。一般来说，匿名内部类用于继承其他类或是实现接口，并不需要增加额外的方法，只是对继承方法的实现或是重写。
	
	/*
	 * 4.静态内部类
	 * 	 4.1静态内部类也是定义在另一个类里面的类，只不过在类的前面多了一个关键字static。静态内部类是不需要依赖于外部类的，
	 *      这点和类的静态成员属性有点类似，并且它不能使用外部类的非static成员变量或者方法。
	 */

}


