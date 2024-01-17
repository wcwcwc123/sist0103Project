package day0117;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyShopList_07 {

    final static String FILENAME = "C:\\sist0103\\file\\myshop.txt";
    List<MyShop> list = new ArrayList<MyShop>();
    Scanner sc = new Scanner(System.in);

    public MyShopList_07(){
        shopFileRead();
    }

    //파일읽기
    public void shopFileRead() {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            while (true) {
                String shop = br.readLine();

                if (shop == null) {
                    break;
                }
                String[] d = shop.split(",");
                String sang = d[0];
                int su = Integer.parseInt(d[1]);
                int price = Integer.parseInt(d[2]);
                int total = su * price;

                //MyShop클래스에 저장 #1
                MyShop s = new MyShop();
                s.setSangpum(sang);
                s.setSu(su);
                s.setPrice(price);
                s.setTotal(total);

                //MyShop클래스에 저장 #2
                MyShop s2 = new MyShop(sang, su, price);
                s2.setTotal(total);
                list.add(s);
            }
            System.out.println("파일에서 총 "+list.size()+"개의 상품목록 가져옴");
        } catch (FileNotFoundException e) {

            e.printStackTrace();
            try {
                Thread.sleep(1000);
                System.out.println("저장된 파일이 없습니다");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //파일쓰기
    public void shopFileWrite() {
        FileWriter fw = null;

        try {
            fw = new FileWriter(FILENAME);

            //MyShop클래스의 내용을 얻어서 출력
            for (MyShop shop : list) {
                String s = shop.getSangpum() + "," + shop.getSu() + "," + shop.getPrice() + ","+shop.getTotal()+ "\n";
                //System.out.println(s);
                fw.write(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Myshop입력
    public void shopAdd() {
        System.out.println("추가할 상품명은?");
        String sang = sc.nextLine();
        System.out.println("수량은?");
        int su = Integer.parseInt(sc.nextLine());
        System.out.println("가격은?");
        int price = Integer.parseInt(sc.nextLine());


        //MyShop클래스 생성
        MyShop shop = new MyShop(sang, su, price);
        shop.setTotal(su*price);
        list.add(shop);
        System.out.println("**상품정보가 추가됨**");
    }

    //파일전체출력
    public void shopAllDatas() {
        if (list.size() == 0) {
            System.out.println("출력할 상품이 없습니다");
            return; //현재 메서드 종료
        }
        System.out.println("\t**전체 상품 정보**");
        System.out.println();
        System.out.println("번호\t상품\t수량\t가격\t총금액");
        System.out.println("---------------------------------");

        int no=1;
        for (MyShop s : list) {
            System.out.println(no++ + "\t" + s.getSangpum() + "\t" + s.getSu() + "\t" + s.getPrice() + "\t" + s.getTotal());
        }
    }

    //메인 프로세스 메서드
    public void process() {
        int num =0;
        while (true) {
            System.out.println("1. 상품추가   2.상품출력   3.상품삭제   4.상품검색  9.종료");
            num = Integer.parseInt(sc.nextLine());

            if (num == 1) {
                this.shopAdd();

            } else if (num == 2) {
                this.shopAllDatas();

            } else if (num == 3) {
                this.shopDelete();

            } else if (num==4) {
                this.shopSearch();

            } else if (num == 9) {

                System.out.println("shop정보를 저장후 종료합니다");
                this.shopFileWrite();
                System.exit(0);
            } else {
                System.out.println("숫자를 다시 입력해주세요");
            }
            System.out.println();

        }
    }

    //상품삭제
    public void shopDelete() {
        String sang;
        System.out.println("삭제할 상품명을 입력하세요");
        sang = sc.nextLine();

        boolean flag =false;
        int count =0;

        //같은상품이 여러개일때 모두 삭제되려면 끝에서부터 반복문 돌린다
        //앞에서부터 삭제시 남은상품 인덱스가 바뀐다
        for (int i = list.size() - 1; i >= 0; i--) {
            MyShop shop = list.get(i);

            if (shop.getSangpum().equals(sang)) {
                flag = true;
                list.remove(i);
                count++;
            }
        }
        if (flag) {
            System.out.println(count+"개가 삭제됨");
        }
    }

    //상품검색
    public void shopSearch() {

        System.out.println("검색할 상품 입력");
        String sang = sc.nextLine();

        boolean flag = false;
        int count =0;

        System.out.println("***검색 결과 ***");
        for (MyShop shop : list) {
            if (shop.getSangpum().contains(sang)) {
                flag = true;
                System.out.println("상품명: " + shop.getSangpum());
                System.out.println("수량: " + shop.getSu());
                System.out.println("가격: " + shop.getPrice());
                System.out.println("총금액: " + shop.getTotal());
                System.out.println("-------------------");
                count ++;
            }
        }
        if (flag == true) {
            System.out.println(count + "개가 검색되었습니다");
        }
    }

    public static void main(String[] args) {

        MyShopList_07 ms = new MyShopList_07();
        ms.process();

    }
}
