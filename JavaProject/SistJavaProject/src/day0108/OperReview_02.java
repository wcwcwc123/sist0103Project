package day0108;

import java.util.Calendar;
import java.util.Scanner;

public class OperReview_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int myBirthYear, age;
        String name, ddi;

        System.out.println("이름입력");
        name = sc.nextLine();

        System.out.println("태어난 연도 입력");
        myBirthYear = sc.nextInt();

        Calendar cal = Calendar.getInstance();
        age = cal.get(cal.YEAR) - myBirthYear;


        ddi = myBirthYear%12 == 0 ? "원숭이":
                myBirthYear % 12 == 1 ? "닭" :
                        myBirthYear % 12 == 2 ? "개" :
                                myBirthYear % 12 == 3 ? "돼지" :
                                        myBirthYear % 12 == 4 ? "쥐" :
                                                myBirthYear % 12 == 5 ? "소" :
                                                        myBirthYear % 12 == 6 ? "호랑이" :
                                                                myBirthYear % 12 == 7 ? "토끼" :
                                                                        myBirthYear % 12 == 8 ? "용" :
                                                                                myBirthYear % 12 == 9 ? "뱀" :
                                                                                        myBirthYear % 12 == 10 ? "말" :"양";

        System.out.println("이름"+name);
        System.out.println("현재나이: " + age + "세");
        System.out.println("띠: " + ddi + "띠");
    }

}
