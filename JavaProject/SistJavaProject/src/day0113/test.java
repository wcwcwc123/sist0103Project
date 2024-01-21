package day0113;

public class test {

    public static void main(String[] args) {

        String test = "1 2 3 4 5 6 ";
        System.out.println(test.split(" "));

        for (String s : test.split(" ")) {
            System.out.println(s);
            
        }

    }
}
