package day0113;

import java.util.*;
import java.util.List;

public class ListEx_07 {

    public static void main(String[] args) {
        //1.순차적으로 데이터 들어간다
        //2. 중복데이터도 허용
        //3. 처음생성시 일정한 갯수로 생성되는데 그이상의 데이터를 넣으면
        // 자동으로 공간이 늘어난다

        List<String> list = new Vector<String>();
        List<String> list2 = new ArrayList<String>();
        //생성자가 디폴트인경우 기본할당크기 10
        System.out.println("초기할당크기: "+list.size());

        list.add("장미");
        list.add("장미");
        list.add("장미");
        list.add("장미");
        list.add("장미");
        list.add("장미");
        list.add("장미");
        System.out.println("초기할당크기: "+list.size());
        System.out.println("출력_#1");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("출력_#2");
        for (String s : list) {
            System.out.println(s);
        }

        System.out.println("출력_#3");
        Iterator<String> iter = list.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println("출력_#4");
        Object[] ob = list.toArray();
        for (int i = 0; i < ob.length; i++) {
            System.out.println(ob[i]);
        }
    }
}
