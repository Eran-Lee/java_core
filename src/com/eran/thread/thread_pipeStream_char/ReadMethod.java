package com.eran.thread.thread_pipeStream_char;

import java.io.IOException;
import java.io.PipedReader;

public class ReadMethod {
	public void readMethod(PipedReader reader) {
		try {
			System.out.println("开始读：");
			char[] charArray = new char[20];
			int read = reader.read(charArray);
			while(read != -1) {
				String string = new String(charArray, 0, read);
				System.out.print(string + " ");
				read = reader.read(charArray);
			}
			System.out.println();
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
