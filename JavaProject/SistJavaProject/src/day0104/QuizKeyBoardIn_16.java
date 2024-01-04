package day0104;

import java.util.Scanner;

public class QuizKeyBoardIn_16 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String productName;
		int price,qty,total;
		
		System.out.print("상품명을 입력하세요==>");
		productName = sc.nextLine();
		System.out.print("가격은 얼마입니까?==>");
		price = sc.nextInt();
		System.out.print("수량은 몇개입니까?==>");
		qty= sc.nextInt();
		total = price * qty;
		
		System.out.println("\n상품입고");
		System.out.println("==================");
		System.out.printf("입고상품명: %s\n",productName);
		System.out.printf("수량: %d개\n",qty);
		System.out.printf("가격: %d원\n",price);
		System.out.println("==================");
		System.out.printf("총가격: %d원\n",total);
		
	}
}
