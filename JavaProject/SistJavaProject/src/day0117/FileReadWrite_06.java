package day0117;

import java.io.*;
import java.text.NumberFormat;
import java.util.Scanner;

public class FileReadWrite_06 {

    Scanner sc = new Scanner(System.in);
    final static String FILENAME = "C:\\sist0103\\file\\shop.txt";
    FileReader fr = null;
    BufferedReader br = null;

    FileWriter fw = null;
    public int getMenu() {
        int num;

        System.out.println("[메뉴] 1.상품추가    2.전체상품출력   5.종료");
        num = Integer.parseInt(sc.nextLine());
        return num;
    }

    //입력후 파일에 저장
    public  void sangpumAdd() {

        String sangName;
        int su,dan;

        //바나나,10,3500 이런식으로 파일에 저장
        System.out.println("상품명 입력");
        sangName = sc.nextLine();
        System.out.println("수량 입력");
        su = Integer.parseInt(sc.nextLine());
        System.out.println("단가 입력");
        dan = Integer.parseInt(sc.nextLine());

        try {
            fw = new FileWriter(FILENAME, true);
            fw.write(sangName + "," + su + "," + dan + "\n");

            System.out.println("**추가되었습니다**");
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

    //파일출력
    public void fileAllDatas() {
        int total = 0;
        int num = 0;

        NumberFormat nf = NumberFormat.getInstance();
        NumberFormat nf2 = NumberFormat.getCurrencyInstance();

        //제목출력
        System.out.println("번호\t상품명\t수량\t단가\t금액");
        System.out.println("-------------------------------");

        try {
            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            while (true) {
                String s = br.readLine();

                if (s == null) {
                    break;
                }
                String[] data = s.split(",");
                String sangName = data[0];
                int su = Integer.parseInt(data[1]);
                int dan = Integer.parseInt(data[2]);
                System.out.println(++num +"\t"+ sangName + "\t" + su + "\t" + nf2.format(dan) + "\t" + nf.format(su*dan));

            }
        } catch (FileNotFoundException e) {
            System.out.println("파낫파0에러");
            e.printStackTrace();
            System.out.println("파낫파 에러");

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("아이오 에러");
        }finally {
        }
    }

    //메인에서 처리할 메서드
    public void process() {
        int ch=1 ;


        while (ch!=5) {
            ch = this.getMenu();
            switch (ch) {
                case 1:
                    this.sangpumAdd();
                    break;
                case 2:
                    this.fileAllDatas();
                    break;
                case 5:
                    break;
                default:
                    System.out.println("숫자 다시 입력");
                    break;
            }
        }
        System.out.println("종료");

    }

    public static void main(String[] args) {
        FileReadWrite_06 fw = new FileReadWrite_06();

        fw.process();



    }
}
