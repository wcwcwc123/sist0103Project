package day0104;

public class Quiz_14 {
	public static void main(String[] args) {
		String productName = args[0];
		int qty = Integer.parseInt(args[1]);
		int price = Integer.parseInt(args[2]);
		int total = qty * price;
		
		System.out.printf("상품명: %s\n",productName);
		System.out.printf("수량: %d개\n",qty);
		System.out.printf("단가: %d원\n",price);
		System.out.printf("총금액: %d원\n",total);
		
		
		
	}
}
