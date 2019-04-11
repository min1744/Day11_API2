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

public class ClientTest {
	public static void main(String[] args) {
		Socket s=null;
		OutputStream os=null;
		OutputStreamWriter ow = null;
		BufferedWriter bw = null;
		InputStream is=null;
		InputStreamReader ir = null;
		BufferedReader br = null;
		Scanner sc = new Scanner(System.in);
		String str = null;
		ClientInfo ci = new ClientInfo();
		boolean check = true;
		
		try {
			s = new Socket("211.238.142.22", 8180);
			System.out.println("서버와 접속 성공");
			while(check) {
				check = ci.sendServer(os, s, ow, bw, str, sc);
				if(!check) {
					break;
				}
				check = ci.receiveServer(is, s, ir, br, str);
				if(!check) {
					break;
				}
			}
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
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}