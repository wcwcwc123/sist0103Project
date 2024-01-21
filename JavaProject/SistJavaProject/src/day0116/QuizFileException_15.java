package day0116;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuizFileException_15 {

    public static void fruitread() {
        String fName = "C:\\sist0103\\file\\fruitshop.txt";
        FileReader fr = null;
        BufferedReader br = null;

        int num=1;

        try {
            fr = new FileReader(fName);
            br = new BufferedReader(fr);

            System.out.println("**과일입고목록**");
            System.out.println("번호\t\t과일명\t\t수량\t\t단가 \t\t총금액");
            System.out.println("---------------------------------------------------");

            while (true) {
                String s = br.readLine();

                if (s == null) {
                    break;
                }
                String[] fruitInfo = s.split(",");//과일명,수량,가격
                String fruitName = fruitInfo[0];
//                if (fruitName.length() < 3) {
//                    fruitName += " ";
//                }
                int qty = Integer.parseInt(fruitInfo[1]);
                int price = Integer.parseInt(fruitInfo[2]);
                int qq = Integer.parseInt(fruitInfo[1]) * Integer.parseInt(fruitInfo[2]);
                int total = qty*price;
                System.out.println(num+"\t\t"+fruitName+"\t\t"+qty+"\t\t"+price+"원\t\t"+total+"원");
                //System.out.printf("%d %-5s %-3d %-7d원 %-10d원\n",num,fruitName,qty,price,total);
                num++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fruitread();

    }
}
