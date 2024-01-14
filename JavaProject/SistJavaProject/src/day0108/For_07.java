package day0108;

public class For_07 {
    public static void main(String[] args) {
        int i = 10;
        System.out.println("**while문으로 10~0 출력**");
        while(i>=0){
            System.out.println(i--+" ");
        }
        System.out.println();
        System.out.println("**for문으로 10~0 출력**");

        for (int a=10; a>0; a--){
            System.out.println(a + " ");
        }
        System.out.println();
        System.out.println("**for문으로 1~10 종료**");
        for (int a=1;a<=10;a++){
            System.out.println(a+" ");
        }
        System.out.println("종료");

        System.out.println("** for문 HelloJava 를 5번 반복");

        for (int s = 1; s <= 5; s++) {
            System.out.print("HelloJava"+" ");
        }
    }
}
