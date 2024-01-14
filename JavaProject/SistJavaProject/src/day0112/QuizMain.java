package day0112;

import java.util.Scanner;

//class School{
//
//    static int studentNum = 0;
//}

class Student{

    public String name;
    public int java;
    public int oracle;
    public int html;


    public Student(String name, int java, int oracle, int html) {
        this.name = name;
        this.java = java;
        this.oracle = oracle;
        this.html = html;
    }

    public int getTotal(){
        int total = this.html + this.java + this.oracle;
        return total;
    }
    public double getAverage(){
        return (double)getTotal()/3;
    }

    public String getPyungga(){
        double avg = getAverage();

        if(avg>=90){
            return "장학생";
        } else if (avg >= 80) {
            return "합격";
        } else {
            return "불합격";
        }
    }

}


public class QuizMain {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("학교이름 입력");
        String schoolName = sc.nextLine();

        System.out.println("학생수 입력");
        int totalStudent = sc.nextInt();
        sc.nextLine();

        Student[] sList = new Student[totalStudent];

        for (int i = 0; i < totalStudent; i++) {
            System.out.printf("%d번째 학생 이름 입력: ",i+1);
            String tempName = sc.nextLine();

            System.out.printf("%d번째 학생 java성적 입력: ",i+1);
            int tempJava = sc.nextInt();
            System.out.printf("%d번째 학생 oracle성적 입력: ",i+1);
            int tempOracle = sc.nextInt();
            System.out.printf("%d번째 학생 html성적 입력: ",i+1);
            int tempHtml = sc.nextInt();
            sc.nextLine();
            sList[i] = new Student(tempName, tempJava, tempOracle, tempHtml);
        }

        System.out.printf("학교명: %s\n",schoolName);

        System.out.println("이름\tJAVA\tORACLE\tHTML\t총점\t평균\t평가");
        for (int i = 0; i < sList.length; i++) {
            System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\t%s\n",sList[i].name,sList[i].java,sList[i].oracle,sList[i].html,sList[i].getTotal(),sList[i].getAverage(),sList[i].getPyungga());
        }


    }
}
