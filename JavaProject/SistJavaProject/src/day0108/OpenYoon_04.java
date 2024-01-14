package day0108;

import java.util.Scanner;

public class OpenYoon_04 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int year,month,days;
        boolean flag;

        System.out.println("년도와 월을 입력해 주세요");
        year = sc.nextInt();
        month = sc.nextInt();

        //월 잘못 입력시 프로그램 종료
        if (month < 1 || month > 12) {
            System.out.println("월을 잘못입력했어요!!");
            return;
        }

        //윤년구하기
        flag = year%4==0 && year%100 !=0 || year%400 ==0;

        //if(flage = true)
        if (flag) {
            System.out.println(year + "년도는 윤년입니다");
        }else{
            System.out.println(year + "년도는 평년입니다");
        }

        //해당년도의 월이 몇일까지 있는지 구하기
        if(month==4 || month ==6 || month==9 || month==11){
            days = 30;
        } else if (month == 2) {
            if(flag){
                days=29;
            }else{
                days=28;
            }
        }else{
            days = 31;
        }
        System.out.println(year+"년 "+month + "월은 " + days+"일 까지 있습니다");
    }
}
