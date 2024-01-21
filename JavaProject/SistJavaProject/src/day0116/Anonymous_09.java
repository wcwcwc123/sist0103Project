package day0116;

abstract class AbstObj {
    abstract public void dataIn();
    abstract public void dataOut();
}
class SubAbst extends AbstObj{

    @Override
    public void dataIn() {
        System.out.println("상속_데이터입력");
    }

    @Override
    public void dataOut() {
        System.out.println("상속_데이터출력");
    }
}

public class Anonymous_09 {

    AbstObj ab1 = new AbstObj() {
        @Override
        public void dataIn() {
            System.out.println("익명내부클래스_데이터입력");
        }

        @Override
        public void dataOut() {
            System.out.println("익명내부클래스_데이터출력");
        }
    };

    public static void main(String[] args) {
        SubAbst subab = new SubAbst();
        subab.dataIn();
        subab.dataOut();

        Anonymous_09 ab9 = new Anonymous_09();
        ab9.ab1.dataIn();
        ab9.ab1.dataOut();

    }

}
