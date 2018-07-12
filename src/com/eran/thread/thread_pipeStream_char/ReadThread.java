package com.eran.thread.thread_pipeStream_char;

import java.io.PipedReader;

public class ReadThread extends Thread{
	private PipedReader input;
	private ReadMethod reader;
	
	public ReadThread(PipedReader input, ReadMethod reader) {
		this.reader = reader;
		this.input = input;
	}
	
	@Override
	public void run() {
		reader.readMethod(input);
	}
}
