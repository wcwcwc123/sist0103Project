package day0104;

import java.util.Calendar;

public class Calendar_11 {
	public static void main(String[] args) {
		Calendar cal  = Calendar.getInstance();
		
		System.out.println(cal.DATE);
		System.out.println("지금은"+cal.get(cal.YEAR)+"년도 입니다");
		System.out.println("지금은"+(cal.get(cal.MONTH)+1)+"월 입니다");
		System.out.println("지금은"+cal.get(cal.DATE)+"일 입니다");
		System.out.println("지금은"+cal.get(cal.DAY_OF_MONTH)+"일 입니다");
		System.out.println("시간: "+cal.get(cal.HOUR_OF_DAY)+"시"+cal.get(cal.MINUTE)+"분"+cal.get(cal.SECOND)+"초"+cal.get(cal.MILLISECOND)+"밀리초");
	}

}
