package com.eran.thread.thread_pipeStream_char;

import java.io.PipedWriter;

public class WriteThread extends Thread{
	private PipedWriter output;
	private WriteMethod writer;
	
	public WriteThread (PipedWriter output, WriteMethod writer) {
		this.output = output;
		this.writer = writer;
	}
	
	@Override
	public void run() {
		writer.writeMethod(output);
	}

}
