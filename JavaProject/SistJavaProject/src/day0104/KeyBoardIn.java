package day0104;

import java.util.Scanner;

public class KeyBoardIn {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String name;
		int age;
		String home;
		
		System.out.print("이름을 입력해보세요==>");
		name = sc.nextLine();
		
		System.out.print("나이를 입력하세요==>");
		age = sc.nextInt();// 숫자로 읽어온다.
		//숫자입력후 엔터누르면 그 엔터가 키보드 버퍼로 저장되어
		//다음문자열 읽을때 먼저 읽어오는 현상발생
		//그래서 다음문자열 읽기전에 그엔터 읽어 없애기...sc.nextLine()
		
		System.out.print("당신이 사는 지역은?==>");
		home = sc.nextLine();
		
		System.out.println(name+"님의 나이는"+age+"세 입니다");
	}

}
