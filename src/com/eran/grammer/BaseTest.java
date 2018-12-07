package com.eran.grammer;

public class BaseTest {

	public static void main(String[] args) {
		Integer i1 = new Integer(14);
		Integer i2 = new Integer(14);
		Integer i3 = 14;
		System.out.println(i1 == i2 );
		System.out.println(i1.equals(i2));
		
		System.out.println(i1 == i3);
		System.out.println(i1.equals(i3));
		
		System.out.println("int和Integer == 比较" + (i2 == i3.intValue()));
		System.out.println("int和Integer equels 比较" + (i2.equals(i3.intValue())));
		
		Integer num1 = 127;
		Integer num2 = 127;
		System.out.println("num1 == num2" + (num1 == num2));
		Integer num3 = 128;
		Integer num4 = 128;
		System.out.println("num3 == num4" + (num3 == num4));
		
		System.out.println("********");
		
		
        // 两个new出来的Integer类型的数据比较，
        //相当于把new出来的地址作比较
        
        Integer a0 = new Integer(1);// 普通的堆中对象
        Integer b0 = new Integer(1);
        System.out.println("new出来的 " + "a0==b0 :" + (a0 == b0));
        System.out.println(a0);

        // 调用intValue方法得到其int值
        System.out.println("调用intValue " + "a0.intValue() == b0.intValue()" + 
        (a0.intValue() == b0.intValue()));

        // 把Integer类型的变量拆箱成int类型
        int c = 1;
        System.out.println("将Integer自动拆箱 " + "a0==c: " + (a0 == c));

        // 其实也是内存地址的比较
        Integer a1 = 30; // 自动装箱，如果在-128到127之间，则值存在常量池中
        Integer b1 = 30;
        System.out.println("直接赋值的两个Integer的比较" + 
        "a2 == b2: "+ (a1 == b1));

        Integer a2 = 30;
        Integer b2 = 40;
        System.out.println("直接赋值的两个Integer的比较 " + 
        "a6==b6: " + (a2 == b2));

        Integer a3 = 128;
        Integer b3 = 128;
        System.out.println("直接赋值的两个Integer的比较 " + 
        "a5 == b5: " + (a3 == b3));

        Integer a4 = 412;
        Integer b4 = 412;
        System.out.println("直接赋值的两个Integer的比较 " + 
        "a4 == b4: " + (a4 == b4));
        // 从这里看出，当给Integer直接赋值时，
        //如果在-128到127之间相等的话，它们会共用一块内存
        // 而超过这个范围，则对应的Integer对象有多少个就开辟多少个

        System.out.println("调用intValue " + "a4.intValue() == b4.intValue(): " 
        + (a4.intValue() == b4.intValue()));
    }
}
