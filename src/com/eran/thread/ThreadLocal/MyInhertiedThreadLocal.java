package com.eran.thread.ThreadLocal;

import java.util.Date;

public class MyInhertiedThreadLocal extends InheritableThreadLocal<Object>{

	@Override
	protected Object initialValue() {
		return new Date().getTime();
	}
	
	@Override
	protected Object childValue(Object parentValue) {
		return parentValue +  "我只会出现在子线程中";
	}
}
