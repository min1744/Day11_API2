package com.iu.io.file;

import java.io.File;

public class FileTest {

	public static void main(String[] args) {
		File file = new File("C:\\test\\ex1.txt");
		file = new File("c:\\test", "ex1.txt");
		file = new File("C:\\test");
		File file2 = new File(file, "ex1.txt");
		System.out.println(file.exists());
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.length());//파일의 크기
		
		File f = new File("c:\\");
		String [] str = f.list();
		File [] list = f.listFiles();
		
		file = new File("c:\\test\\iu\\test");
		//file.mkdir() : 디렉터리 만들기
		//file.mkdirs() : 디렉터리 만들기
		file = new File("c:\\test\\test2\\iu");
		file.delete();
	}
}