package day0113;

import java.util.*;

public class SetRandom_06 {

    public static void main(String[] args) {
        Random r = new Random();
        Set<Integer> set = new HashSet<Integer>();

        while(true){

            int n = r.nextInt(45)+1;
            set.add(n);

            if (set.size() == 6) {
                break;
            }
        }
        System.out.println("출력_#1");
        for (int n : set) {
            System.out.printf("%5d ",n);
        }

        System.out.println();
        System.out.println("출력_#2");

        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.printf("%5d ",iter.next());
        }


        System.out.println();
        System.out.println("출력_#3");

        Object[] ob = set.toArray();
        Arrays.sort(ob);

        for (int i = 0; i < ob.length; i++) {
            System.out.printf("%5d ",ob[i]);
        }

    }
}
