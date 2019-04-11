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
import java.util.Scanner;

public class ServerInfo {
	//sendClient
	//receiveClient
	public boolean sendClient(OutputStream os, Socket sc, OutputStreamWriter ow, BufferedWriter bw, String s, Scanner ssc) throws Exception {
		os = sc.getOutputStream();
		ow = new OutputStreamWriter(os);
		bw = new BufferedWriter(ow);
		System.out.print("클라이언트로 보낼 메세지 입력 : ");
		s = ssc.next();
		bw.write(s);
		bw.write("\r\n");
		bw.flush();
		boolean check = true;
		if(s.equals("end")) {
			System.out.println("프로그램을 종료합니다.");
			check = !check;
		}
		return check;
	}

	public boolean receiveClient(ServerSocket ss, InputStream is, Socket sc, InputStreamReader ir, BufferedReader br, String s) throws Exception {
		is = sc.getInputStream();
		ir = new InputStreamReader(is);//char
		br = new BufferedReader(ir);
		s = br.readLine();
		boolean check = true;
		if(s.equals("end")) {
			System.out.println("프로그램을 종료합니다.");
			check = !check;
		}
		System.out.println("Message : " + s);
		return check;
	}
}