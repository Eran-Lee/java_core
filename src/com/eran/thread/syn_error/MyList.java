package com.eran.thread.syn_error;

import java.util.ArrayList;
import java.util.List;

public class MyList {
	private List<String> list = new ArrayList<>();
	
	synchronized public void add(String data) {
		list.add(data);
	}
	
	synchronized public int getSize() {
		return list.size();
	}
}
