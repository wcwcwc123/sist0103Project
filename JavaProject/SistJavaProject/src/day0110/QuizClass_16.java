package day0110;

class Mart{
    private String sangpum;
    int su;
    int dan;
    static String SHOPNAME = "롯데마트";

    public void setSangpum(String sangpum) {
        this.sangpum = sangpum;
    }
    public String getSangpum(){
        return this.sangpum;
    }

    public Mart(){

    }
    public Mart(String sangpum,int su, int dan){
        this.sangpum = sangpum;
        this.su = su;
        this.dan = dan;
    }
}

public class QuizClass_16 {
    public static void main(String[] args) {

        Mart m1 = new Mart("쵸코파이", 10, 4500);
        Mart m2 = new Mart();

        m2.setSangpum("엄마손파이");
        m2.su = 5;
        m2.dan = 2500;

        System.out.println("**" + Mart.SHOPNAME + " 입고상품***");
        System.out.println("상품명: " + m1.getSangpum());
        System.out.println("수량: " + m1.su+"개");
        System.out.println("가격: " + m1.dan + "원");
        System.out.println("--------------------------");
        System.out.println("상품명: " + m2.getSangpum());
        System.out.println("수량: " + m2.su+"개");
        System.out.println("가격: " + m2.dan + "원");



    }


}
