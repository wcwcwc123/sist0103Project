package day0116;


import java.util.Scanner;

class UserException extends Exception {

    public UserException(String msg) {
        super(msg); // Exception클래스 생성자 통해 정식 메세지로 등록
    }
}
public class ThrowException_03 {

    public static void  process() throws UserException {
        Scanner sc = new Scanner(System.in);
        int age = 0;

        System.out.println("나이 입력");
        age = sc.nextInt();

        if (age < 10 || age > 59) {
            throw new UserException("우리모임의 나이는 10~59세 입니다");
        } else {
            System.out.println("당신은" + age + "세 이므로 등록가능");
        }
    }
    public static void main(String[] args) {
        try {
            process();
        } catch (UserException e) {
            System.out.println("오류메세지: " + e.getMessage());
        }

    }
}
