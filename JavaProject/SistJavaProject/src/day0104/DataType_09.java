package day0104;

public class DataType_09 {
	public static void main(String[] args) {
		int java = Integer.parseInt(args[0]);
		int jsp = Integer.parseInt(args[1]);
		int spring = Integer.parseInt(args[2]);
		
		int tot = java + jsp + spring;
		int count = 3;
		
		double avg1 = tot/count;
		double avg2 = (double)tot/count;
		
		System.out.println(avg1);
		System.out.println(avg2);
		
		System.out.printf("java=%d, jsp=%d, spring=%d\n",java,jsp,spring);
		System.out.println("총점="+tot);
		
		System.out.printf("평균=%.2f\n",avg1);
	}
}
