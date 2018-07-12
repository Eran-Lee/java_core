package com.eran.thread.thread_pipeStream_char;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class TestThread {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, IOException {
		PipedWriter output = new PipedWriter();
		PipedReader input = new PipedReader();
		output.connect(input);
		
		ReadMethod read = new ReadMethod();
		WriteMethod write = new WriteMethod();
		
		ReadThread readThread = new ReadThread(input, read);
		readThread.start();
		
		Thread.sleep(1000);
		
		WriteThread writeThread = new WriteThread(output, write);
		writeThread.start();
	}

}
