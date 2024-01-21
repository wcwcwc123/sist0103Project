package day0116;

abstract class AbEx {

    abstract public void dataAdd();
    abstract public void dataList();
}

public class Anonymous_08 {
    AbEx ab = new AbEx() {
        @Override
        public void dataAdd() {
            System.out.println("데이터를 추가합니다");
        }

        @Override
        public void dataList() {
            System.out.println("데이터를 출력합니다");

        }
    };

    public static void main(String[] args) {

        Anonymous_08 anony = new Anonymous_08();
        anony.ab.dataAdd();
        anony.ab.dataList();


    }
}
