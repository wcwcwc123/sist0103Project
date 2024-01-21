package day0113;

import java.util.*;

//HashSet: 순서를 유지하지않는 데이터 집합,중복허용 안됨
//구현클래스,인덱스 없음
//Set인터페이스를 구현하려면 HashSet
//<E> 제네릭: 타입을 명시하면 그이외 타입을 넣으면 오류
public class HashSet_04 {
    public static void main(String[] args) {
        //컬렉션은 가변적이므로 배열의 고정형을 보완해준다

        Set<String> set1 = new HashSet<String>();
        //set1안에 String만을 담겠다_Set은 인터페이스이므로 생성안됨 그걸 구현한
        //클래스인 HashSet으로 생성

        set1.add("사과");
        set1.add("오렌지");
        set1.add("배");
        set1.add("사과");
        set1.add("키위");
        set1.add("바나나");

        System.out.println("데이터 갯수: "+set1.size());

        System.out.println("출력_#1");
        for (String s : set1) {
            System.out.println(s);
        }
        System.out.println();

        System.out.println("출력_#2");
        Iterator<String> iter = set1.iterator();

        while (iter.hasNext()) {
            String s = iter.next();
            System.out.println(s);
        }
        Object[] ob= set1.toArray();
        //List<> ll = new ArrayList<String>();

        for (int i = 0; i < ob.length; i++) {
            System.out.println(ob[i]);
        }

        //모든데이터 삭제
        set1.clear();

        //확인
        if (set1.isEmpty()) {
            System.out.println("비어있다.");
        } else {
            System.out.println("데이터가 있다.");
        }

    }
}
