package com.iu.network.client;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientInfo {
	//메서드 : sendServer
	//메서드 : receiveServer
	public boolean sendServer(OutputStream os, Socket s, OutputStreamWriter ow, BufferedWriter bw, String str, Scanner sc) throws Exception {

		os = s.getOutputStream();
		ow = new OutputStreamWriter(os);//char
		bw = new BufferedWriter(ow);
		System.out.print("서버로 보낼 메세지 입력 : ");
		str= sc.next();
		bw.write(str);
		bw.write("\r\n");
		bw.flush();
		boolean check = true;
		if(str.equals("end")) {
			System.out.println("프로그램을 종료합니다.");
			check = !check;
		}
		return check;
	}

	public boolean receiveServer(InputStream is, Socket s, InputStreamReader ir, BufferedReader br, String str) throws Exception {
		is = s.getInputStream();
		ir = new InputStreamReader(is);//char
		br = new BufferedReader(ir);
		str = br.readLine();
		boolean check = true;
		if(str.equals("end")) {
			System.out.println("프로그램을 종료합니다.");
			check = !check;
		}
		System.out.println("Message : "+str);
		return check;
	}
}