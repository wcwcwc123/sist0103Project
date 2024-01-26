package day0126;

import oracleDB.DbConnect;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class QuizStuInfo {

    DbConnect db = new DbConnect();

    public void insertInfo() {

        Scanner sc = new Scanner(System.in);
        System.out.println("학생명?");
        String name = sc.nextLine();

        System.out.println("성별?");
        String gender = sc.nextLine();

        System.out.println("나이?");
        String age = sc.nextLine();

        System.out.println("연락처?");
        String phone = sc.nextLine();


        String sql = String.format("insert into stuinfo values(seq_info.nextval,'%s','%s','%s','%s',sysdate)", name, gender, age, phone);
        System.out.println(sql);

        Connection conn = db.getOracle();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            stmt.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(stmt,conn);
        }
    }
    public Collection<Integer> printInfo() {


        Connection conn = db.getOracle();
        Statement stmt =null;
        ResultSet rs = null;
        String sql = "select * from stuinfo";

        Collection<Integer> seqList = new ArrayList<Integer>();

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("시퀀스\t학생명\t성별\t\t나이\t\t\t연락처\t\t\t가입일");
            System.out.println("==========================================================");

            while (rs.next()) {
                int seq = rs.getInt("s_no");
                String name = rs.getString("s_name");
                String gender = rs.getString("s_gender");
                int age = rs.getInt("s_age");
                String phone = rs.getString("s_hp");
                String gaipay = rs.getDate("gaipday").toString();

                seqList.add(seq);
                System.out.println(seq+"\t\t"+name+"\t"+gender+"\t\t"+age+"\t\t"+phone+"\t"+gaipay);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,stmt,conn);
            return seqList;
        }
    }

    public void deleteInfo() {


        Scanner sc = new Scanner(System.in);
        System.out.println("삭제할 시퀀스는?");
        int num = sc.nextInt();

        String sql = "delete from stuinfo where s_no="+num;

        Connection conn = db.getOracle();
        Statement stmt =null;
        try {
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);

            if (a == 0) {
                System.out.println("삭제할 데이터가 없습니다");
            } else {
                System.out.println("삭제완료");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(stmt,conn);
        }
    }
    public void updateInfo() {

        Collection seq_list = printInfo();
        Scanner sc = new Scanner(System.in);
        String sql = "";


        System.out.println("수정할 시퀀스는?");
        int seq = sc.nextInt();
        sc.nextLine();

        if (!seq_list.contains(seq)) {
            System.out.println("해당 데이터가 존재하지 않습니다");
        } else {
            System.out.println("수정할 학생명?");
            String name = sc.nextLine();

            System.out.println("수정할 성별?");
            String gender = sc.nextLine();

            System.out.println("수정할 나이?");
            String age = sc.nextLine();

            System.out.println("수정할 연락처?");
            String phone = sc.nextLine();

            sql = String.format("update stuinfo set s_name='%s',s_gender='%s',s_age=%s,s_hp='%s' " +
                    "where s_no=%s", name, gender, age, phone,seq);

            Connection conn = db.getOracle();
            Statement stmt=null;
            try {
                stmt = conn.createStatement();
                int a = stmt.executeUpdate(sql);

                System.out.println(a+"개 데이터가 수정되었습니다.");


            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                db.dbClose(stmt,conn);
            }
        }
    }

    public void searchInfo() {
        Scanner sc = new Scanner(System.in);

        System.out.print("학생명 검색: ");
        String s =sc.nextLine();


        String sql = "select * from stuinfo " +
                "where s_name like '%%" +s+
                "%%'";


        Connection conn = db.getOracle();
        Statement stmt=null;
        ResultSet rs =null;
        try {
            stmt = conn.createStatement();
            rs =  stmt.executeQuery(sql);


            if (rs.next()) {
                System.out.println("시퀀스\t학생명\t성별\t\t나이\t\t\t연락처\t\t\t가입일");
                System.out.println("==========================================================");

                int seq = rs.getInt("s_no");
                String name = rs.getString("s_name");
                String gender = rs.getString("s_gender");
                int age = rs.getInt("s_age");
                String phone = rs.getString("s_hp");
                String gaipay = rs.getDate("gaipday").toString();

                System.out.println(seq+"\t\t"+name+"\t"+gender+"\t\t"+age+"\t\t"+phone+"\t"+gaipay);

                while (rs.next()) {

                    seq = rs.getInt("s_no");
                    name = rs.getString("s_name");
                    gender = rs.getString("s_gender");
                    age = rs.getInt("s_age");
                    phone = rs.getString("s_hp");
                    gaipay = rs.getDate("gaipday").toString();

                    System.out.println(seq+"\t\t"+name+"\t"+gender+"\t\t"+age+"\t\t"+phone+"\t"+gaipay);

                }
            } else {
                System.out.println("**검색결과가 존재하지 않습니다.**\n");
            }





        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,stmt,conn);
        }


    }




    public static void main(String[] args) {

        QuizStuInfo manager = new QuizStuInfo();

        int ch=0;

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("1.학생정보입력  2.정보출력  3.정보삭제  4.학생정보 수정  5.학생검색  9.종료");
            ch = sc.nextInt();
            sc.nextLine();
            if (ch == 1) {
                //insert
                manager.insertInfo();

            } else if (ch == 2) {
                //select
                manager.printInfo();
            } else if (ch == 3) {
                //delete
                manager.deleteInfo();
            } else if (ch == 4) {
                //update
                manager.updateInfo();
            } else if (ch == 5) {
                //search
                manager.searchInfo();
            } else if (ch == 9) {
                //exit
                break;
            }
        }
    }
}
