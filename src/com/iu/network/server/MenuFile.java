package com.iu.network.server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.iu.io.file.rw.Member;

public class MenuFile {
	public void menu(File file) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String str = null;
			br.readLine();
			while(true) {
				str = br.readLine();
				if(str == null)
					break;
				String [] menus = str.split(",");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}