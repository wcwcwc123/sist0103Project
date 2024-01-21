package day0116;

import java.util.StringTokenizer;

public class StringToken_13 {
    public static void main(String[] args) {
        //문자열을 특정기호로 분리하는 방법들
        String str = "red,yellow,cyan,gray,pink";

        System.out.println("String 객체의 split을 이용한 분리");

        System.out.println(str.split(","));
        for (String s : str.split(",")) {
            System.out.println(s);
        }
        System.out.println(str.split(",")[0]);

        System.out.println("String 객체의 split을 이용한 분리");
        String[] arrColors = str.split(",");

        System.out.println("String 객체의 StringTokenizer을 이용한 분리");
        StringTokenizer st = new StringTokenizer(str, ",");
        System.out.println("총 토큰수: " + st.countTokens());

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
