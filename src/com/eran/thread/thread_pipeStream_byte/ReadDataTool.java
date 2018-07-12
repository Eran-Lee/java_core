package com.eran.thread.thread_pipeStream_byte;

import java.io.IOException;
import java.io.PipedInputStream;

public class ReadDataTool {

	public void readMethod(PipedInputStream input) {
		try {
			System.out.println("开始了读取：");
			byte[] byteArray = new byte[20];
			int read = input.read(byteArray);	//这个方法是阻塞的，知道读到东西，才会继续。
			System.out.println("read:" + read);
			while(read != -1) {
				String str = new String(byteArray, 0, read);
				System.out.print(str + " ");
				read = input.read(byteArray);
			}
			System.out.println();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
