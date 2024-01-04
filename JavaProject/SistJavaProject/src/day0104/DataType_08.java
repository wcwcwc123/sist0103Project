package day0104;

public class DataType_08 {
	public static void main(String[] args) {
		// 묵시적형변환은 자동으로 결정되는 타입
		// String + int = String
		// double + int = double
		// long + short = long
		// char + int = int
		
		char a = 'A'; // 아스키코드값 65
		System.out.println(a+32);
		System.out.println("Happy"+5+6);
		System.out.println("Happy"+(5+6));
		System.out.println('A'+3);
		System.out.println(2+'b');
		System.out.println(String.valueOf(++a));
		
	}

}
