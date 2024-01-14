package day0108;

import java.util.Scanner;

public class QuizFor_12 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int total=0;
        int score;
        System.out.print("1. ");
        for (int i = 1; i <= 10; i++) {
            if(i%3== 0){
                continue;
            }

            System.out.print(i+" ");
        }

        System.out.print("\n2. ");

        for (int j = 1; j <= 10; j++) {
            if (j % 2 == 1) {
                System.out.printf("홀수값:%d\t",j);
            }
        }
        System.out.print("\n3. ");

        while (true) {
            System.out.println("점수를 입력하세요");
            score = sc.nextInt();
            if (score == 0) {
                break;
            }
            total += score;

        }
        System.out.println("총합계: "+total);
    }
}
