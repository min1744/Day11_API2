package com.iu.io.file.rw;

import java.util.ArrayList;

public class MemberView {
	public void view(String s) {
		System.out.println(s);
	}
	public void view(ArrayList<Member> arm) {
		for(Member s:arm) {
			System.out.println("그룹명 : " + s.getGroup());
			System.out.println("이름 : " + s.getName());
			System.out.println("나이 : " + s.getAge());
			System.out.println("역할 : " + s.getRes());
			System.out.println("소속사 : " + s.getCompany());
			System.out.println();
		}
	}
	//member 하나를 출력하는 메서드
	public void view(Member member) {
			System.out.println("그룹명 : " + member.getGroup());
			System.out.println("이름 : " + member.getName());
			System.out.println("나이 : " + member.getAge());
			System.out.println("역할 : " + member.getRes());
			System.out.println("소속사 : " + member.getCompany());
			System.out.println();
		
	}
}