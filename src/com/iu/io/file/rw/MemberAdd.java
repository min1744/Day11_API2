package com.iu.io.file.rw;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberAdd {
	public void addMember(Scanner sc, ArrayList<Member> arm, Member member) {
		member = new Member();
		System.out.print("그룹명 : ");
		member.setGroup(sc.next());
		System.out.print("이름 : ");
		member.setName(sc.next());
		System.out.print("나이 : ");
		member.setAge(sc.nextInt());
		System.out.print("역할 : ");
		member.setRes(sc.next());
		System.out.print("소속사 : ");
		member.setCompany(sc.next());
		arm.add(member);
	}
	
	public void backUp(ArrayList<Member> arm) {
		//파일의 저장경로 : readtest에 덮어쓰기
		File file = new File("c:\\test\\readTest.txt");
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(file, true);
			for(Member s:arm) {
				fw.write("\r\n" + s.getGroup() + "\r-");
				fw.write(s.getName() + "\r-");
				fw.write(s.getAge() + "\r-");
				fw.write(s.getRes() + "\r-");
				fw.write(s.getCompany() + "\r");
			}
			fw.flush();//버퍼를 강제로 비우기
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("백업 완료");
	}
}