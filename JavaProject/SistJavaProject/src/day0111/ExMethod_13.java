package day0111;

/*
메서드: 접근제한자(public) + 지정예약어(static) + 결과형리턴값(void) + 메서드명()
반복적인 코드를 줄여 코드의 관리가 쉽다
하나의 메서드는 한가지 기능만을 수행하도록 작성
 */

public class ExMethod_13 {

    public static boolean aaa(){
        return false;
    }
    public static int bbb(){
        return 11;
    }

    public static int ccc(int x,int y) {
        return 0;
    }

    public static void main(String[] args) {
        boolean a= aaa();
        System.out.println("a=" + a);

        int b = bbb();
    }
}
