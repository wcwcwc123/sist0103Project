package day0113;

//key value로 이루어지는 데이터의 집합
//key로 구분
//순서유지되지않는다
//키는 중복허용하지않고 값은 중복을 허용한다.

import java.util.*;

public class MapEx_11 {

    public static void main(String[] args) {

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("name", "강호동");
        m.put("age", 33);
        m.put("addr", "서울시");

        //같은 키값으로 넣으면 먼저 데이터는 없어짐
        m.put("name", "수지");

        System.out.println("개수: " + m.size());
        System.out.println("키값을 알면 value값을 정확히 얻을수있다");

        System.out.println("이름: " + m.get("name"));
        System.out.println("나이: " + m.get("age"));
        System.out.println("사는곳: " + m.get("addr"));

        System.out.println("키값을 먼저 한꺼번에 얻은후 값을 얻는방법");

        Set<String> keyset = m.keySet();
        System.out.println("**방법1**");
        Iterator<String> keyiter = keyset.iterator();

        while (keyiter.hasNext()) {
            String key = keyiter.next();
            System.out.println(key+"==>"+m.get(key));
        }

        System.out.println("**방법2**");
        for (String key : keyset) {
            System.out.println(key+"==>"+m.get(key));
        }
    }
}
