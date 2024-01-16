package day0116;

class Outer{

    String name = "test";
    int age = 22;

    class Inner1{

        //내부클래스에서는 외부클래스의 멤버변수사용 가능하다
        public void disp() {
            System.out.println("**Inner1 내부 클래스**");
            System.out.println("이름: "+name+", 나이: "+age);
        }

    }
    class Inner2{
        public void disp2() {
            System.out.println("**Inner2 내부 클래스**");
            System.out.println("이름: "+name+", 나이: "+age);

        }

    }

    public void write() {
        Inner1 in1 = new Inner1();
        in1.disp();

        Inner2 in2 = new Inner2();
        in2.disp2();
    }
}
public class InnerObj_05 {

    public static void main(String[] args) {
        Outer out = new Outer();
        out.write();

        System.out.println("=========================");
        System.out.println("다른클래스에서 외부통하지 않고 직접 내부클래스 메서드 호출하고 싶다면??");
        Outer.Inner1 in1 = new Outer().new Inner1();
        in1.disp();

        Outer.Inner2 in2 = new Outer().new Inner2();
        in2.disp2();
    }
}
