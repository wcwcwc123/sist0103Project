package day0110;

public class ArrayChange_03 {
    public static void main(String[] args) {

        //순서바꾸기 연습

        int a=10,b=20;
        System.out.println("a= " + a + ", b=" + b);

        int temp=a;
        a = b;
        b = temp;
        System.out.println("a= " + a + ", b=" + b);

        int[] n = {5, 8, 4};

        for (int s : n) {
            System.out.println(s + " ");
        }
        System.out.println("0번이랑 2번을 교환후 출력");
        int temp2 =n[0];
        n[0] = n[2];
        n[2] = temp2;

        for (int s : n) {
            System.out.println(s + " ");
        }

    }
}
