package day0108;

import java.util.Scanner;

public class Quiz_18 {
    public static void main(String[] args) {
//        quiz_1();
        quiz_2();
    }

    public static void quiz_1(){
        //Q. 반복해서 숫자를 입력하여 양수의 갯수와 음수의 갯수를 구하시오(0입력시 종료)
//        6
//      -10
//       88
//       120
//      -130
//        0
//      양수의 갯수:3개
//      음수의 갯수:2개
        Scanner sc = new Scanner(System.in);
        int num;
        int plus = 0;
        int minus = 0;

        System.out.println("숫자입력(0입력시 종료)");
        while(true){

            num = sc.nextInt();
            if (num == 0) {
                break;
            }
            if (num > 0) {
                plus++;
            }else if(num <0){
                minus++;
            }
        }
        System.out.printf("양수의 갯수: %d개\n",plus);
        System.out.printf("음수의 갯수: %d개\n",minus);
    }
    public static void quiz_2(){
        //반복해서 점수를 입력하고(1~100) 0을 입력시 빠져나와 갯수와 합계와 평균을 구하시오
        //범위에 맞지않는 점수는 횟수에서 제외되어야 한다
        Scanner sc = new Scanner(System.in);
        int num;
        int total = 0;
        double avg = 0.0;
        int count = 0;

        System.out.println("숫자입력(1~100)(0입력시 종료)");
        while(true){

            num = sc.nextInt();
            if (num >= 1 && num <= 100) {
                count++;
                total += num;

            } else if (num == 0) {
                avg = (double)total/count;
                break;
            }
        }
        System.out.printf("합계: %d\n",total);
        System.out.printf("평균: %.2f\n",avg);

    }
}
