package com.eran.thread.thread_pipeStream_char;

import java.io.IOException;
import java.io.PipedWriter;

public class WriteMethod {
	public void writeMethod(PipedWriter writer) {
		try {
			System.out.println("开始写");
			for (int i = 0; i < 30; i++) {
				String data = (i + 1) + "";
				writer.write(data);

				System.out.print(data + " ");
			}
			System.out.println();
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
