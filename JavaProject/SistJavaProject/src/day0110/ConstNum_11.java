package day0110;


//생성자: 객체 생성시 자동호출되는 메서드
//1.일반메서드와 차이점: 리턴형이 없다
//2. 반드시 클래스명과 같다
//3. 오버로딩
class Numb{
    int num; //0

    //디폴트 생성자
    public Numb(){
        System.out.println("디폴트 생성자 호출");
    }
    //인자있는 생성자
    public Numb(int num) {
        this.num = num;
        System.out.println("인자있는 생성자 호출");
    }

    //메서드
    public int getNumber(){

        return this.num;
    }
}
public class ConstNum_11 {

    public static void main(String[] args) {
        Numb n1 = new Numb();

        Numb n2 = new Numb(30);
        System.out.println(n2.num);

        Numb n3 = new Numb(50);
        System.out.println(n3.getNumber());


    }
}
