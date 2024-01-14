package day0110;

public class StaticInstance_09 {

    static int count = 0;

    //생성자
    public StaticInstance_09() {
        count++;
        System.out.println(count);
    }

    public static void main(String[] args) {

        //객체변수는 항상 독립적이므로 count는 서로다른 메로리를 가지므로 증가하지 않는다
        //static은 공유하므로 증가
        StaticInstance_09 s1=new StaticInstance_09();
        StaticInstance_09 s2=new StaticInstance_09();
    }
}
