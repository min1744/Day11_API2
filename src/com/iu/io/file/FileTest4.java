package com.iu.io.file;

import java.io.File;
import java.util.HashMap;

public class FileTest4 {

	public static void main(String[] args) {
		File file = new File("c:\\test\\iu");
		//확장자, bmp, jpg, gif, png
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("bmp", "img");
		map.put("jpg", "img");
		map.put("gif", "img");
		map.put("png", "img");
		map.put("jpeg", "img");
		String [] names = file.list();
		for(int i=0;i<names.length;i++) {
			int index = names[i].lastIndexOf('.');
			String n = names[i].substring(index+1);
			if(!(map.get(n)!= null && map.get(n).equals("img"))) {
				File file2 = new File(file, names[i]);
				file2.delete();
			}
			
		}
	}
}