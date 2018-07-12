package com.eran.thread.thread_pipeStream_byte;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class ThreadTest {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws InterruptedException, IOException {
		WriteDataTool writer = new WriteDataTool();
		ReadDataTool reader = new ReadDataTool();
		
		PipedInputStream input = new PipedInputStream();
		PipedOutputStream output = new PipedOutputStream();
		
		input.connect(output);
		
		ThreadReader threadReader = new ThreadReader(input, reader);
		threadReader.start();
		
		Thread.sleep(2000);
		
		ThreadWriter threadWriter = new ThreadWriter(writer, output);
		threadWriter.start();
	}

}
