package com.iu.network.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class ServerTest2 {
	
	public static void main(String[] args) {
		ServerSocket ss = null;
		Socket s = null;
		InputStream is = null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os = null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		ArrayList<String> ar = new ArrayList<String>();
		Random rd = new Random();
		
		try {
			System.out.println("Server : 클라이언트 접속 받을 준비 중...");
			ss = new ServerSocket(8180);
			s = ss.accept();
			System.out.println("Server : 연결 성공");
			is = s.getInputStream();
			ir = new InputStreamReader(is);
			br = new BufferedReader(ir);
			String names = br.readLine();
			
			String [] name = names.split(",");
			for(int i = 0; i < name.length; i++) {
				ar.add(name[i].trim());
			}
			os = s.getOutputStream();
			ow = new OutputStreamWriter(os);
			bw = new BufferedWriter(ow);
			int random = rd.nextInt(ar.size())+1;
			for(int i = 0; i < ar.size(); i++) {
				if(random == i) {
					bw.write(ar.get(i));
				}
			}
			bw.write("\r\n");
			bw.flush();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				ir.close();
				is.close();
				bw.close();
				ow.close();
				os.close();
				s.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}