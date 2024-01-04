package day0104;

import java.util.Scanner;

public class KeyBoardIn_15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String stuName;
		int kor,eng,mat;
		int total;
		double avg;
		
		System.out.println("학생명?");
		stuName = sc.nextLine();
		System.out.println("국 영 수 점수를 입력하시오");
		kor = sc.nextInt();
		eng = sc.nextInt();
		mat = sc.nextInt();
		
		total = kor+eng+mat;
		avg = total/3.0;
		
		System.out.printf("학생명: %s\n",stuName);
		System.out.printf("국어 점수: %s\n",kor);
		System.out.printf("영어 점수: %s\n",eng);
		System.out.printf("수학 점수: %s\n",mat);
		System.out.printf("총점: %s\n",total);
		
		
		
	}
}
