package day0116;

import java.util.Scanner;

class SawonOuter{
    private String sawonName;
    private int gibonPay,familySu,timeSu;

    public void process() {

        //데이터입력

        //결과출력

    }

    class InputInner{
        public void inputData() {
            Scanner sc = new Scanner(System.in);
            System.out.println("사원명 입력");
            sawonName = sc.nextLine();
            System.out.println("기본급?");
            gibonPay = sc.nextInt();
            System.out.println("초과시간은?");
            timeSu = sc.nextInt();
            System.out.println("가족수는?");
            familySu = sc.nextInt();
        }

    }

    class SudangInner{
        public int getTimeSudang() {
            return timeSu*30000;
        }

        public int getFamilySudang(){
            if (familySu <= 4) {
                return 200000;
            } else {
                return 300000;
            }
        }
        public int getTax() {
            return (int)(gibonPay*0.03);
        }

        public int getTotalPay() {
            return gibonPay+getFamilySudang()+getTimeSudang()-getTax();
        }

        public void writeSawonData() {
            System.out.println("사원명\t기본급\t초과근무시간\t가족수\t시간수당\t가족수당\t세금\t총급여");
            System.out.println(sawonName+"\t"+gibonPay+"\t"+timeSu+"\t"+familySu+"\t"+getTimeSudang()+"\t"+getTax()+"\t"+getTotalPay());
        }

    }
}

public class QuizInnerClass_10 {
    public static void main(String[] args) {

        SawonOuter sawon = new SawonOuter();

        SawonOuter.InputInner input = sawon.new InputInner();
        input.inputData();

        SawonOuter.SudangInner output = sawon.new SudangInner();
        output.writeSawonData();

    }
}
