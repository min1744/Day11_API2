package com.iu.io.file;

import java.io.File;
import java.util.Scanner;

public class FileTest5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		File file = new File("c:\\test");
		String [] list = file.list();
		boolean check = true;
		
		System.out.print("디렉터리 이름을 입력하세요 : ");
		String dir = sc.next();
		File file2 = null;
		for(int i = 0; i < list.length; i++) {
			file2 = new File(file, list[i]);
			if(dir.equals(list[i])) {
				file2 = new File(file, list[i]);
				file2.delete();
				System.out.println("삭제되었습니다.");
				check = !check;
				break;
			}
		}
		if(check) {
			file2 = new File(file, dir);
			file2.mkdir();
			System.out.println("추가되었습니다.");
		}
	}
}