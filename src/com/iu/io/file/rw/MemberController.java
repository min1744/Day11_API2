package com.iu.io.file.rw;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberController {
	MemberInfo mi;
	MemberView mv;
	Scanner sc;
	ArrayList<Member> arm;
	boolean check;
	MemberAdd ma;
	Member m;
	
	public MemberController() {
		mi = new MemberInfo();
		mv = new MemberView();
		sc = new Scanner(System.in);
		arm = null;
		check = true;
		ma = new MemberAdd();
		m = new Member();
	}
	public void start() {
		
		
		while(check) {
			System.out.println("1. 멤버정보 가져오기");
			System.out.println("2. 멤버정보 출력하기");
			System.out.println("3. 멤버검색 출력하기");
			System.out.println("4. 그룹검색 출력하기");
			System.out.println("5. 멤버 추가");
			System.out.println("6. 백       업");
			System.out.println("7. 종       료");
			System.out.print("번호를 입력하세요 : ");
			int select = sc.nextInt();
			if(select == 1) {
				arm = mi.getMembers();
			}else if(select == 2) {
				mv.view(arm);
			}else if(select == 3) {
				m = mi.searchMember(sc, arm);
				if(m != null) {
					mv.view(m);
				}else
					mv.view("멤버가 없습니다.");
			}else if(select == 4) {
				ArrayList<Member> search = mi.searchGroup(sc, arm);
				if(search.size() > 0) {
					mv.view(search);
				}else
					mv.view("데이터가 없습니다.");
			}else if(select == 5) {
				ma.addMember(sc,arm, m);
			}else if(select == 6) {
				ma.backUp(arm);
			}else if(select == 7) {
				check = !check;
				sc.close();
				System.out.println("프로그램을 종료합니다.");
			}else
				System.out.println("번호를 잘못 입력하셨습니다.");
		}
	}
}