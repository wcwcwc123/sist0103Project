package day0129;

import oracleDB.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.Math.round;

public class JdbcScore_02 {

    DbConnect db = new DbConnect();
    Scanner sc = new Scanner(System.in);

    public void process() {

        int ch;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1.학생성적 입력      2.학생성적 출력    3.삭제   4.수정      9.종료");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    this.insertSungjuk();
                    break;
                case 2:
                    this.printSungjuk();
                    break;
                case 3:
                    this.deleteSungjuk();
                    break;
                case 4:
                    this.updateSungjuk();
                    break;
                case 9:
                    System.exit(0);
            }
        }

    }


    public void insertSungjuk() {
        System.out.println("학생명?");
        String name = sc.nextLine();
        System.out.println("자바점수?");
        int java = sc.nextInt();
        System.out.println("오라클점수?");
        int oracle = sc.nextInt();
        sc.nextLine();

        int total = java+oracle;
        //double average = round((double)total/2,2);

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        String sql = "insert into sungjuk (num,name,oracle,java) values (seq_score.nextval,?,?,?)";

        try {
            pstmt = conn.prepareStatement(sql);

            //바인딩
            pstmt.setString(1,name);
            pstmt.setInt(2,java);
            pstmt.setInt(3,oracle);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }

    }

    public void printSungjuk() {

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        String sql = "select * from sungjuk";
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("시퀀스\t학생명\t자바점수\t오라클점수\t총점\t평균");
            while (rs.next()) {
                int num = rs.getInt("num");
                String name = rs.getString("name");
                int java = rs.getInt("java");
                int oracle = rs.getInt("oracle");
                int total = rs.getInt("total");
                if (rs.wasNull()) {
                    total = java+oracle;
                }
                double average = rs.getDouble("average");
                if (rs.wasNull()) {
                    average = (java+oracle)/(double)2;
                }


                System.out.println(num + "\t" + name + "\t" + java + "\t" + oracle + "\t" + total + "\t" + average);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }


    }

    public void deleteSungjuk() {
        Scanner sc = new Scanner(System.in);

        this.printSungjuk();


        System.out.println("삭제할 시퀀스를 입력하세요");
        int num = sc.nextInt();

        String sql = "delete from sungjuk where num=?";
        Connection conn = db.getOracle();
        PreparedStatement pstmt =null;

        try {
            pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, num);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }
    }

    public void updateSungjuk() {
        //수정할num을 입력후 java,oracle의 수정값을 입력받아 수정할것
        //num이 있을경우 "수정됨", 없을경우 "5번학생 존재하지 않음"

        printSungjuk();

        System.out.println("수정할 번호 선택");
        int num = sc.nextInt();

        System.out.println("수정할 자바점수 입력");
        int java = sc.nextInt();
        System.out.println("수정할 오라클점수 입력");
        int oracle = sc.nextInt();
        sc.nextLine();

        String sql = "update sungjuk set java =?, oracle =? where num=?";


        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        try {

            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,java);
            pstmt.setInt(2, oracle);
            pstmt.setInt(3, num);
            int n = pstmt.executeUpdate();

            if (n == 0) {
                System.out.println(num + "번 학생은 존재하지 않습니다");
            } else {
                System.out.println(n+"번 학생의 정보가 변경되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }


    }


    public static void main(String[] args) {
        JdbcScore_02 jdbcscore = new JdbcScore_02();
        jdbcscore.process();

    }
}
