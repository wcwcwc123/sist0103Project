package day0113;

public class Exception_12 {

    public static void main(String[] args) {

        System.out.println("프로그램시작");
        try {
            int num = 3 / 0;
        } catch (Exception e) {
            e.printStackTrace(); //자세한 예외정보 출력
        }

        System.out.println("프로그램종료");

    }
}
