package day0104;

public class QuizDataType_10 {
	public static void main(String[] args) {
		String name = args[0];
		String home = args[1];
		int age = Integer.parseInt(args[2]);
		int java = Integer.parseInt(args[3]);
		int oracle = Integer.parseInt(args[4]);
		
		String result = "";
		
		
		System.out.printf("학생명: %s 님\n",name);
		System.out.printf("지역: %s\n",home);
		System.out.printf("나이: %d 세\n",age);
		System.out.println("\n============================");
		System.out.printf("%s님의 자바점수는 %d점\t오라클점수는 %d점\t총 %d점입니다\n",name,java,oracle,(java+oracle));
		System.out.println(result);
		
	}

}
