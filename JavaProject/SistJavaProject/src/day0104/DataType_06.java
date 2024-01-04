package day0104;

public class DataType_06 {
	public static void main(String[] args) {
		// 기본 자료형 8개
		
		boolean flag = false; //논리형 true,false
		
		//문자형
		//반드시 하나의 문자, 16바이트 유니코드값 표현
		//2바이트 문자하나
		//기본적으로 정수형,아스키코드로 변경이 가능하므로
		char ch='가';
		
		//정수
		byte a = -128;
		short b = 32000;
		int c = 670000;
		long d = 10000000L;
		
		//실수
		float f=3.1234f; //32비트 뒤에 f를 붙히지 않으면 double을 의미
		double dd = 32423.2321535235; // 64비트 소수점가진 숫자의미 double
		
		System.out.println("flag=" +flag);
		System.out.println("문자형 ch="+ch);

		System.out.println("정수 a="+a);
		System.out.println("정수 b="+b);
		System.out.println("정수 c="+c);
		System.out.println("정수 d="+d);
		
		System.out.println("실수형 f="+f);
		System.out.println("실수형 dd="+dd);
		
		
	}
}
