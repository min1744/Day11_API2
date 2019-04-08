package com.iu.exception;

import java.util.Scanner;

public class ExceptionTest1 {

	public static void main(String[] args) {
		//Error, Exception
		//Error : 컴파일 시 에러
		//Exception : 실행 중 발생하는 에러
		//예외처리
		//목적 : 비정상적인 종료를 막고 정상적으로 프로그램을 진행하기 위해서
		//방법 :
		//1. try
		//		{예외가 발생 할 만한 코드
		//}
		//catch(발생할 Exception 타입의 예외변수){
		//		예외가 발생했을 시 실행
		//}
		//finally{
		//		
		//}

		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 하나 입력하세요 : ");
		int num = 0;
		int result = 0;
		int a = 10;
		try {
			num = sc.nextInt();
			result = a/num;
			//throw new ArithmeticException();
			int [] ar = new int[3];
			System.out.println(ar[result]);
		}
		catch(Exception e) {
			//개발시에는 예외 메시지 확인
			e.printStackTrace();
			//배포시에는 변경
		}
		System.out.println(result);
		System.out.println(a+num);
		System.out.println("종료");
	}
}