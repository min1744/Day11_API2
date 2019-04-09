package com.iu.io.file.rw;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MemberInfo {
	private ArrayList<Member> searchCompany(Scanner sc, ArrayList<Member> arm){
		ArrayList<Member> search = new ArrayList<Member>();
		System.out.print("소속사명을 입력하세요 : ");
		String company = sc.next();
		for(Member m:arm) {
			if(company.equals(m.getCompany())) {
				search.add(m);
			}
		}
		return search;
	}

	private ArrayList<Member> searchTeam(Scanner sc, ArrayList<Member> arm){
		ArrayList<Member> search = new ArrayList<Member>();
		System.out.print("그룹명을 입력하세요 : ");
		String group = sc.next();
		for(Member m:arm) {
			if(group.equals(m.getGroup())) {
				search.add(m);
			}
		}
		return search;
	}
	
	public ArrayList<Member> getMembers() {
		File file = new File("c:\\test", "readTest.txt");
		FileReader fr = null;
		BufferedReader br = null;
		String [] names = null;
		ArrayList<Member> arm = new ArrayList<Member>();
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String str = null;
			br.readLine();
			while(true) {
				str = br.readLine();
				if(str == null)
					break;
				Member member = new Member();
				names = str.split("-");
				member.setGroup(names[0]);
				member.setName(names[1]);
				member.setAge(Integer.parseInt(names[2]));
				member.setRes(names[3]);
				member.setCompany(names[4]);
				arm.add(member);
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
		return arm;
	}
	
	public Member searchMember(Scanner sc, ArrayList<Member> arm) {
		System.out.print("검색할 이름 : ");
		String name = sc.next();
		Member member = null;
		for(Member m:arm) {
			if(name.equals(m.getName())) {
				member = m;
				break;
			}
		}
		return member;
	}
	
	public ArrayList<Member> searchGroup(Scanner sc, ArrayList<Member> arm){
		ArrayList<Member> search = null; 
		System.out.println("1. 그룹명");
		System.out.println("2. 소속사");
		System.out.print("번호를 입력하세요 : ");
		int select = sc.nextInt();
		if(select == 1) {
			search = this.searchTeam(sc, arm);
		}else if(select == 2) {
			search = this.searchCompany(sc, arm);
		}
		return search;
	}
}