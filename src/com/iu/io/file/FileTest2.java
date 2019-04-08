package com.iu.io.file;

import java.io.File;

public class FileTest2 {

	public static void main(String[] args) {
		//list
		//파일이라면 파일 크기 출력
		//디렉터리라면 폴더입니다. 출력
		File file = new File("c:\\");
		String [] str = file.list();
		for(int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
			File file2 = new File(file, str[i]);
			if(file2.isFile()) {
				System.out.println("파일크기 : " + file.length());
			}else
				System.out.println("폴더입니다.");
		}
		
		File [] lists = file.listFiles();
	}
}