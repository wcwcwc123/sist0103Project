package day0109;

import java.util.Random;

public class Random_05 {
    public static void main(String[] args) {

        Random r = new Random();

        System.out.println("0~9사이의 난수 5개 발생");
        for (int i = 1; i <= 5; i++) {
            int a = r.nextInt(10);
            System.out.println(a);
        }
        System.out.println("---------------------");
        System.out.println("0~99사이의 난수 5개 발생");
        for (int i = 1; i <= 5; i++) {
            int a = r.nextInt(100);
            System.out.println(a);
        }
        System.out.println("---------------------");

    }
}
