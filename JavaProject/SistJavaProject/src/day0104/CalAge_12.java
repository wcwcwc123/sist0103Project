package day0104;

import java.util.Calendar;

public class CalAge_12 {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();
		String name = args[0];
		
		int curYear = calendar.get(calendar.YEAR);
		int myYear = Integer.parseInt(args[1]);
		int myAge = curYear - myYear;
		
		System.out.println("이름: "+ name);
		System.out.println("태어난년도: "+ myYear + "년생");
		System.out.println("나이: "+ myAge+"세");
		
	}

}
