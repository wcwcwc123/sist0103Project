package day0113;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx_05 {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();
        set1.add(5);
        set1.add(2);
        set1.add(3);
        set1.add(11);

        System.out.println("갯수: " + set1.size());
        System.out.println("출력_#1");

        for (int n : set1) {
            System.out.printf("%5d ",n);
        }
        System.out.println();

        System.out.println("출력_#2");
        Iterator<Integer> iter =  set1.iterator();

        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("출력_#3");
        Object [] ob = set1.toArray();
        for (int i = 0; i < ob.length; i++) {
            System.out.printf("%5d ", ob[i]);
        }
    }
}
