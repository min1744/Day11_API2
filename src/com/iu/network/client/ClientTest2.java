package com.iu.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientTest2 {

	public static void main(String[] args) {
		Socket s = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			s = new Socket("211.238.142.22", 8180);
			System.out.println("서버와 접속 성공");
			os = s.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			System.out.print("이름을 입력하세요 : ");
			String names = sc.next();
			bw.write(names);
			bw.write("\r\n");
			bw.flush();
			
			is = s.getInputStream();
			ir = new InputStreamReader(is);//char
			br = new BufferedReader(ir);
			names = br.readLine();
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