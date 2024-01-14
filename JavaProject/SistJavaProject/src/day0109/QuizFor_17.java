package day0109;

import java.util.Scanner;

public class QuizFor_17 {
    public static void main(String[] args) {
        quiz3();
    }
    public static void quiz1(){
        /*
        Q.팩토리얼 구할 숫자를 입력하여 해당숫자에 대한 팩토리얼 구하기

        팩토리얼 구할 숫자 입력
        5
        5!=12
         */
        Scanner sc = new Scanner(System.in);
        int su,result = 1;

        System.out.println("팩토리얼 구할 숫자 입력: ");
        su = sc.nextInt();
        for (int i = 1; i <= su; i++) {
            result *= i;
        }
        System.out.println(su+"!="+result);
    }
    public static void quiz2(){
        /*
        Q. 두수 x,y를 입력후 x의 y승 for문을 이용해서 구하시오(x를 y횟수만큼 곱하는것)

        두수 입력
        3 3
        3의 3승은 27입니다
         */
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = a;
        for (int i = 1; i < b; i++) {
            c = c*a;
        }
        System.out.printf("%d의 %d승은 %d입니다",a,b,c);

    }
    public static void quiz3(){
        /*
        1~100까지의 숫자중 짝수의 합과 홀수의 합을 출력해주세요(for)

        1~100 홀수합: **
        1~100 짝수합: **

         */
        int esum =0;
        int osum =0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                osum+=i;
            }else {
                esum +=i;
            }
        }
        System.out.printf("짝수의 합: %d\n",esum);
        System.out.printf("홀수의 합: %d\n",osum);
    }

}
