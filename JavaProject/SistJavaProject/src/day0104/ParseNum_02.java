package day0104;

public class ParseNum_02 {
	public static void main(String[] args) {
		String su1 = "8.2";
		String su2 = "2.2";
		System.out.println("두수 더하기: "+(su1+su2));
		
		//문자열 su1,su2를 정수타입 int로 변환후 계산해보기
		//wrapper class: 기본형과 클래스형간의 변환을 위한 클래스를
		//(Integer, Double, Long ..)
		Double s1 = Double.parseDouble(su1);
		Double s2 = Double.parseDouble(su2);
		
		
		System.out.println("변환후 두수더하기: "+(s1+s2));
		
	}

}
