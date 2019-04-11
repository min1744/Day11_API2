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

public class ServerTest {
	public static void main(String[] args){
		ServerSocket ss=null;
		Socket sc = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		OutputStream os=null;
		OutputStreamWriter ow=null;
		BufferedWriter bw=null;
		Scanner ssc = new Scanner(System.in);
		ServerInfo si = new ServerInfo();
		String s = null;
		boolean check = true;

		try {
			System.out.println("Server : 클라이언트 접속 받을 준비중");
			ss = new ServerSocket(8180);
			sc = ss.accept();
			System.out.println("Server : 연결 성공");
			while(check) {
				check = si.receiveClient(ss, is, sc, ir, br, s);
				if(!check)
					break;
				check = si.sendClient(os, sc, ow, bw, s, ssc);
				if(!check)
					break;

			}
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
				sc.close();
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}