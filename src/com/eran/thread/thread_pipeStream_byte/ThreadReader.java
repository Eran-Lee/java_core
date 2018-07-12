package com.eran.thread.thread_pipeStream_byte;

import java.io.PipedInputStream;

public class ThreadReader extends Thread{
	
	private PipedInputStream input;
	private ReadDataTool read;
	
	public ThreadReader(PipedInputStream input, ReadDataTool read) {
		this.input = input;
		this.read = read;
	}
	
	@Override
	public void run() {
		read.readMethod(input);
	}
	

}
