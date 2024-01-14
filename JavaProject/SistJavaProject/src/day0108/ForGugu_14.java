package day0108;

import java.util.Scanner;

public class ForGugu_14 {
    public static void main(String[] args) {

        for (int dan = 2; dan <= 9; dan++) {
            for (int j = 1; j <= 9; j++) {
                System.out.println(dan + "X" + j + "=" + dan * j);
            }
            System.out.println();
        }

        for (int dan = 2; dan <= 9; dan++) {
            for (int j = 1; j <= 9; j++) {
                if (j == 5) {
                    break;
                }
                System.out.println(dan + "*" + j + "=" + dan * j);
            }
        }

        System.out.println("Q. 단을 입력하면 해당단이 나오게 해주세요 [5단]");
        Scanner sc = new Scanner(System.in);
        int dan = sc.nextInt();

        for (int i = 1; i < 10; i++) {
            System.out.printf("%d * %d = %d\n",dan,i,dan*i);
        }


    }
}
