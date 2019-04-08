package com.iu.io.file;

import java.io.File;

public class FileTest3 {

	public static void main(String[] args) {
		File file = new File("c:\\test");
		String str = "iu-suji-choa,hani";
		str = str.replace(",", "-");
		String [] ar = str.split("-");
		for(int i = 0; i < ar.length; i++) {
			file = new File(file, ar[i]);
			file.mkdir();
		}
	}
}