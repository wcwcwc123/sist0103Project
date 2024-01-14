package day0108;

import java.util.Scanner;

public class QuizForWhile_15 {
    public static void main(String[] args) {

//        test1();
            test4();
    }

    public static void test1() {
        //문제: 1~100까지의 3의배수 갯수 구하기

        int n=0;
        int cnt = 0;
        while (true) {
            if (n % 3 == 0) {
                cnt ++;
            }
            n++;
            if(n>100){
                break;
            }
        }
        System.out.println("3의배수 개수: "+cnt);

    }
    public static void test2() {
        //1~100까지의 짝수 합 구하기(while true)
        int n=0;
        int sum = 0;
        while (true) {
            if (n % 2 == 0) {
                sum +=n;
            }
            n+=2;
            if(n>100){
                break;
            }
        }
        System.out.println("1~100까지의 짝수합: "+sum);

    }
    public static void test3() {
        //1~100까지의 홀수 합 구하기(while true)
        int n=0;
        int sum = 0;
        while (true) {
            if (n % 2 == 1) {
                sum +=n;
            }
            n+=1;
            if(n>100){
                break;
            }
        }
        System.out.println("1~100까지의 홀수합: "+sum);

    }
    public static void test4(){
        Scanner sc = new Scanner(System.in);
        int total = 0;
        int score;
//        int i = 1;

//        for( ; ;){
//
//            System.out.printf("%d번 점수: ",i);
//            int score = sc.nextInt();
//
//            if(score >=1 && score <=100 ){
//                i++;
//                total += score;
//            }else{
//                System.out.println("잘못 입력했어요");
//            }
//
//            if(i==6){
//                System.out.printf("총점: %d",total);
//                break;
//            }
//        }
        int sum =0;
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + "번 점수: ");
            score = sc.nextInt();

            if (score < 1 || score > 100) {
                System.out.println("잘못 입력했어요");
                i--;
                continue;
            }
            sum += score;
        }
        System.out.printf("총점: %d",sum);
    }
}
