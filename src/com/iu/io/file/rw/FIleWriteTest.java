package com.iu.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FIleWriteTest {

	public static void main(String[] args) {
		File file = new File("c:\\test\\writeTest.txt");
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file, true);
			fw.write("Fifth Write\r\n");
			fw.flush();//버퍼를 강제로 비우기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("파일 작성 완료");
	}
}