package day0126;

import oracleDB.DbConnect;

import javax.xml.namespace.QName;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class HelloCrud {

    DbConnect db = new DbConnect();


    public void insert() {

        Scanner sc = new Scanner(System.in);
        String name,addr;
        String sql ="";
        System.out.println("이름을 입력하세요");
        name =sc.nextLine();

        System.out.println("주소를 입력하세요");
        addr = sc.nextLine();
        sql = "insert into hello values(seq1.nextval,'"+name+"','"+addr+"',sysdate)";
        String sql2 = String.format("insert into hello values(seq1.nextval, '%s', '%s', sysdate)", name, addr);
        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("insert into hello values(seq1.nextval,'")
                .append(name)
                .append("','")
                .append(addr)
                .append("',sysdate)");

        String sql3 = sqlBuilder.toString();

        //1.db연결
        Connection conn = null;
        //2.statement
        Statement stmt = null;

        conn = db.getOracle();

        try {
            //3.sql문 실행
            stmt = conn.createStatement();
            stmt.execute(sql3);
            System.out.println("**데이터 추가됨**");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(stmt, conn);
        }
    }

    public Collection<Integer> select() {

        System.out.println("시퀀스\t이름\t주소\t가입날짜");
        System.out.println("--------------------------------");


        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        conn = db.getOracle();

        Collection<Integer> seqList = new ArrayList<Integer>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("select * from hello");

            while (rs.next()) {
                int seq = rs.getInt("num");
                String name = rs.getString("name");
                String addr = rs.getString("addr");
                String date = rs.getDate("sdate").toString();
                String date2 = rs.getString("sdate");

                seqList.add(seq);
                System.out.println(seq+"\t"+name+"\t"+addr+"\t"+date);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,stmt,conn);
            return seqList;
        }
    }

    public void delete() {

        //삭제할 번호 입력후 삭제
        Scanner sc = new Scanner(System.in);
        String num;
        String sql = "";

        System.out.println("삭제할 번호 입력");
        num = sc.nextLine();

        sql = "delete from hello where num=" + num.trim();
        System.out.println(sql);

        Connection conn = db.getOracle();
        try {
            Statement stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);//성공한 레코드의 갯수

            if (a == 0) {
                System.out.println("없는 데이터 번호 입니다");
            } else {
                System.out.println(a+"개가 삭제되었습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //수정
    public void update() {
        //수정할 시퀀스를 입력후 이름,주소 입력
        Collection<Integer> seqList = select();
        Scanner sc = new Scanner(System.in);
        String num,name,addr;


        System.out.println("수정할 번호를 입력");
        num = sc.nextLine();

        if (!seqList.contains(Integer.parseInt(num))) {
            System.out.println("수정할 데이터가 없습니다");
            return;
        }


        System.out.println("수정할 이름으로 변경해주세요");
        name = sc.nextLine();

        System.out.println("수정할 주소로 변경해주세요");
        addr = sc.nextLine();

        String sql = String.format("update hello set name='%s',addr='%s' " +
                "where num=%s", name, addr, num);
        System.out.println(sql);

        Connection conn = db.getOracle();
        Statement stmt = null;
        try {
            stmt = conn.createStatement();
            int a = stmt.executeUpdate(sql);

            if (a == 0) {
                System.out.println("수정할 데이터가 존재하지 않습니다");
            } else {
                System.out.println("***수정되었습니다***");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(stmt, conn);
        }
    }
    public static void main(String[] args) {

        HelloCrud hello = new HelloCrud();

        Scanner sc = new Scanner(System.in);
        int n;

        while (true) {

            System.out.println("**hello db 연습**");
            System.out.println("1.Insert  2.Select  3.Delete  4.Update  9.Exit");

            n = sc.nextInt();
            sc.nextLine();

            if (n == 1) {
                hello.insert();
            } else if (n == 2) {
                //select
                hello.select();
            } else if (n == 3) {
                //delete
                hello.delete();
            } else if (n == 4) {
                //update
                hello.update();
            } else if (n == 9) {
                break;
                //exit
            } else {
                System.out.println("맞는 숫자입력");
            }

        }

    }
}
