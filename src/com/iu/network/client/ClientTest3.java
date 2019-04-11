package com.iu.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import com.iu.network.server.MenuFile;

public class ClientTest3 {

	public static void main(String[] args) {
		Socket s = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		MenuFile mf = new MenuFile();
		File file = null;
		ArrayList<String> ar = null;
		
		try {
			s = new Socket("211.238.142.22", 8180);
			System.out.println("서버와 접속 성공");
			os = s.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			System.out.println("1.점심메뉴");
			System.out.println("2.저녁메뉴");
			System.out.println("3.둘 다");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();
			if(select == 1) {
				file = new File("c:\\test", "lunch.txt");
			}else if(select == 2) {
				file = new File("c:\\test", "dinner.txt");
			}else if(select == 3) {
				
			}
			ar = mf.menu(file);
			bw.write(ar.toString());
			bw.write("\r\n");
			bw.flush();
			
			is = s.getInputStream();
			ir = new InputStreamReader(is);//char
			br = new BufferedReader(ir);
			ar = br.readLine();
			System.out.println(names);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				ow.close();
				os.close();
				br.close();
				ir.close();
				is.close();
				s.close();
				sc.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}