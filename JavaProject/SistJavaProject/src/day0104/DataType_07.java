package day0104;

public class DataType_07 {
	 public static void main(String[] args) {
		byte a = (byte)1050;
		
		System.out.println(a);
		
		//강제형변환(cast연산자)을 올바르게 사용하는 경우
		int x = 7;
		int y = 4;
		
		System.out.println(x/y); //정수형끼리의 계산결과는 무조건 정수형 int타입
		System.out.println((double)x/y);
		System.out.println(x/(double)y);
		
		//형변환
		double d = 100.0;
		int i = 100;
		int result = (int)d + i;
		double result2 = d+i;
		
		System.out.println(result2);
		
	}

}
