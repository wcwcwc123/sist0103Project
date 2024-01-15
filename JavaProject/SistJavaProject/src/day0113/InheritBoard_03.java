package day0113;


import java.util.Scanner;

interface Command{
    public void write();
}

class Insert implements Command{
    @Override
    public void write() {
        System.out.println("게시물을 작성합니다");
    }
}

class List implements Command{
    @Override
    public void write() {
        System.out.println("게시물을 확인합니다.");
    }
}

class Modify implements Command{
    @Override
    public void write() {
        System.out.println("게시물을 수정합니다..");
    }
}

class Delete implements Command{
    @Override
    public void write() {
        System.out.println("게시물을 삭제합니다");

    }
}


public class InheritBoard_03 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Command comm = null;
        int n;

        exit:while (true) {
            System.out.println("1.추가  2.출력  3.수정  4.삭제  그외.종료");
            System.out.println("========>");
            n = sc.nextInt();

            switch (n) {

                case 1:
                    comm = new Insert();
                    break;
                case 2:
                    comm = new List();
                    break;
                case 3:
                    comm = new Modify();
                    break;
                case 4:
                    comm = new Delete();
                    break;
                default:
                    System.out.println("종료합니다.");
                    break exit;

            }
            if (n <= 4) {
                comm.write(); //1,2,3,4,출력
            }
        }


    }
}
