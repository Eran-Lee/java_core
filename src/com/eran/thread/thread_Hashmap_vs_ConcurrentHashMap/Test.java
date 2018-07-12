package com.eran.thread.thread_Hashmap_vs_ConcurrentHashMap;

import java.util.concurrent.ConcurrentHashMap;

public class Test {

	/*
	 * HashMap vs ConcurrentHashMap
	 * 1.历史背景
	 * 		jdk1.2,就有了HashMap,但是线程不安全，在jdk1.5,伟大的Doug Lea给我们带了concurrent包，从此Map也安全了。
	 * 
	 * 2.ConcurrentHashMap怎么实现线程安全的
	 * 	 <1>ConcurrentHashMap具体是怎么实现线程安全的呢，肯定不可能是每个方法加synchronized，那样就变成了HashTable。
	 * 	 <2>从ConcurrentHashMap代码中可以看出，它引入了一个“分段锁”的概念，具体可以理解为把一个大的Map拆分成N个小的HashTable，
	 * 		根据key.hashCode()来决定把key放到哪个HashTable中。
	 * 	 <3>在ConcurrentHashMap中，就是把Map分成了N个Segment，put和get的时候，都是现根据key.hashCode()算出放到哪个Segment中。
	 * 	 <4>这里的Segment相当于HashTable。
	 */
	private static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();
	public static void main(String[] args) {
		new Thread("th1") {
			@Override
			public void run() {
				map.put(3, 55);
			}
		}.start();;
		new Thread("th2") {
			@Override
			public void run() {
				map.put(4, 56);
			}
		}.start();;
		new Thread("th1") {
			@Override
			public void run() {
				map.put(7, 57);
			}
		}.start();;
		System.out.println(map);
	}
	
	//虽然测试了一下，但是还是没有弄明白。

}
