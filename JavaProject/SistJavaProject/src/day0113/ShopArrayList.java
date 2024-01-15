package day0113;

import java.util.Scanner;
import java.util.Vector;
import java.util.List;

class Shop{

    private String sangName;
    private int su;
    private int dan;

    public Shop(String sangName, int su, int dan) {
        this.sangName = sangName;
        this.su  = su;
        this.dan = dan;
    }

    public String getSangName() {
        return sangName;
    }

    public void setSangName(String sangName) {
        this.sangName = sangName;
    }

    public int getSu() {
        return su;
    }

    public void setSu(int su) {
        this.su = su;
    }

    public int getDan() {
        return dan;
    }

    public void setDan(int dan) {
        this.dan = dan;
    }
}

public class ShopArrayList {

    List<Shop> slist = new Vector<Shop>();

    public void ipgo(){
        String name;
        int su2,dan2;

        Scanner sc = new Scanner(System.in);
        System.out.println("상품명?");
        name = sc.nextLine();
        System.out.println("가격?");
        dan2 = sc.nextInt();
        System.out.println("수량?");
        su2 = sc.nextInt();
        sc.nextLine();

        slist.add(new Shop(name,su2,dan2));
        System.out.printf("현재 상품 수량은 %d개입니다",slist.size());
    }

    public void jego(){
        System.out.println("No. \t 상품명 \t 가격 \t 수량 \t 총액 \n");

        for (int i = 0; i < slist.size(); i++) {
            System.out.printf("%d \t %s \t %d \t %d \t %d \n",i+1,slist.get(i).getSangName(),slist.get(i).getDan(),slist.get(i).getSu(),slist.get(i).getDan()*slist.get(i).getSu());
        }
    }


    public static void main(String[] args) {

        ShopArrayList sal = new ShopArrayList();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("////////////////////////////");
            System.out.println("1.상품입고    2.상품재고    9.종료");
            int ch = Integer.parseInt(sc.nextLine());

            if (ch == 1) {
                sal.ipgo();

            } else if (ch == 2) {
                sal.jego();

            }else{
                break;
            }

        }

    }
}
