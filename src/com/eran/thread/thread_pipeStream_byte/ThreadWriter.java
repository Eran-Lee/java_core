package com.eran.thread.thread_pipeStream_byte;

import java.io.PipedOutputStream;

public class ThreadWriter extends Thread{
	private WriteDataTool writer;
	private PipedOutputStream output;
	
	public ThreadWriter(WriteDataTool writer, PipedOutputStream output) {
		this.writer = writer;
		this.output = output;
	}
	
	@Override
	public void run() {
		writer.readMethod(output);
	}

}
