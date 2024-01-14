package day0108;

public class sumTest_11 {
    public static void main(String[] args) {

        int sum=0;

        for (int i = 1; i <= 10; i++) {
            sum+=i;

        }
        System.out.println("1~10까지의 합: "+sum+"입니다");

        //while
        int n =1;
        int tot=0;

        while (n <= 10) {
            tot +=n;
            n++;
        }

        System.out.println("1~10까지의 합: "+tot+"입니다");

        System.out.println("for문으로 1~10까지중 2씩 증가할 경우의 합계를 구하시오");
        int total = 0;
        for (int i = 1; i <= 10; i+=2) {
            total += i;
        }
        System.out.printf("합계: %d",total);
    }
}
