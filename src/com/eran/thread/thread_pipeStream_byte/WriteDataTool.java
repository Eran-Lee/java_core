package com.eran.thread.thread_pipeStream_byte;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class WriteDataTool {

	public void readMethod(PipedOutputStream output) {
		try {
			System.out.println("开始了写了：");
			for (int i = 0; i < 30; i++) {
				String outData = "" + (i + 1);
				output.write(outData.getBytes());
				System.out.print(outData + "*");
			}
			System.out.println();
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
