package day0129;

import oracleDB.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class JdbcPstmt {

    DbConnect db = new DbConnect();
    //Scanner scanner = new Scanner(System.in);


    //Insert
    public void insertSangpum() {
        Connection conn = db.getOracle();
        Scanner scanner = new Scanner(System.in);

        PreparedStatement pstmt = null;

        System.out.println("type?");
        String type = scanner.nextLine();

        System.out.println("상품명?");
        String sang = scanner.nextLine();

        System.out.println("수량?");
        int su = scanner.nextInt();
        scanner.nextLine();

        System.out.println("단가?");
        int dan = Integer.parseInt(scanner.nextLine());

        //PreparedStatement는 미완의 sql문을 작성할수 있다
        //변수를 ?로 표시후 나중에 바인딩 시켜주면 된다
        String sql = "insert into sales values(seq1.nextval,?,?,?,?,sysdate)";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, type);
            pstmt.setString(2, sang);
            pstmt.setInt(3, su);
            pstmt.setInt(4, dan);

            //업데이트
            int n = pstmt.executeUpdate();
            if (n == 1) {
                System.out.println("성공");
            } else {
                System.out.println("실패");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
    }
    public Collection<Integer> printSangpum(String op) {
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Collection<Integer> seqList = new ArrayList<Integer>();


        String sql = "select * from sales order by num asc";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("public Collection<Integer> printSangpum(String op)");
            System.out.println("시퀀스\t카테고리\t상품명\t수량\t단가\t입고일");
            System.out.println("------------------------------------------------");


            while (rs.next()) {
                int num = rs.getInt("num");
                seqList.add(num);
                System.out.println(num+"\t"
                                +rs.getString("type")+"\t"
                                +rs.getString("sangpum")+"\t"
                                +rs.getInt("su")+"\t"
                                +rs.getInt("dan")+"\t"
                                +rs.getDate("ipgo")
                        );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
            return seqList;
        }

    }
    public void printSangpum() {
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        //Collection<Integer> seqList = new ArrayList<Integer>();


        String sql = "select * from sales order by num asc";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            System.out.println("public void printSangpum()");
            System.out.println("시퀀스\t카테고리\t상품명\t수량\t단가\t입고일");
            System.out.println("------------------------------------------------");


            while (rs.next()) {
                int num = rs.getInt("num");
                //seqList.add(num);
                System.out.println(num+"\t"
                        +rs.getString("type")+"\t"
                        +rs.getString("sangpum")+"\t"
                        +rs.getInt("su")+"\t"
                        +rs.getInt("dan")+"\t"
                        +rs.getDate("ipgo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt,conn);
            //return seqList;
        }

    }

    void deleteSangpum() {

        Scanner sc = new Scanner(System.in);
        Collection<Integer> numList = new ArrayList<Integer>();
        numList = printSangpum("delete");
        System.out.println("삭제할 시퀀스를 입력하세요");
        int delSeq = sc.nextInt();
        sc.nextLine();
        if (!numList.contains(delSeq)) {
            System.out.println("해당 상품이 존재하지 않습니다");
            return;
        }

        String sql = "delete from sales where num=?";
        
        Connection conn = db.getOracle();
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            //바인딩
            pstmt.setInt(1,delSeq);
            int n = pstmt.executeUpdate();

            if (n == 1) {
                System.out.println("삭제성공");
            } else {
                System.out.println("삭제실패");
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateSangpum() {

        Connection conn = db.getOracle();
        Scanner sc = new Scanner(System.in);

        Collection<Integer> list = printSangpum("update");


        System.out.println("수정할 시퀀스?");
        int seq = sc.nextInt();
        sc.nextLine();
        if (!list.contains(seq)) {
            System.out.println("해당 상품이 없습니다");
            return;
        }
        System.out.println("변경 상품종류?");
        String type = sc.nextLine();
        System.out.println("변경 상품명?");
        String sangpum = sc.nextLine();
        System.out.println("변경 개수?");
        int qty = sc.nextInt();
        System.out.println("수정할 단가는?");
        int price = sc.nextInt();
        sc.nextLine();

        String sql = "update sales set type =?,sangpum=?,su=?,dan=? where num=? ";
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,type);
            pstmt.setString(2, sangpum);
            pstmt.setInt(3, qty);
            pstmt.setInt(4, price);
            pstmt.setInt(5,seq);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt,conn);
        }

    }

    public void searchSangpum() {


        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 상품명을 입력하세요");
        String searchName = sc.nextLine();

        String sql = "select * from sales where sangpum like ?";

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%"+searchName+"%");
            rs = pstmt.executeQuery();

            System.out.println("%"+searchName+"%");
            System.out.println("시퀀스\t카테고리\t상품명\t수량\t단가\t입고일");
            System.out.println("------------------------------------------------");


            while (rs.next()) {
                int num = rs.getInt("num");
                System.out.println(num+"\t"
                        +rs.getString("type")+"\t"
                        +rs.getString("sangpum")+"\t"
                        +rs.getInt("su")+"\t"
                        +rs.getInt("dan")+"\t"
                        +rs.getDate("ipgo")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
        }


    }



    public static void main(String[] args) {
        JdbcPstmt sales = new JdbcPstmt();

        Scanner sc = new Scanner(System.in);
        int ch=9;


        while (true) {
            System.out.println("***상품입고***");
            System.out.println("1.상품추가    2.상품전체출력    3.상품삭제    4.상품수정  5.상품검색   9.종료");
            ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                //상품추가
                sales.insertSangpum();
            } else if (ch == 2) {
                //상품출력
                sales.printSangpum();
            } else if (ch == 3) {
                //상품삭제
                sales.deleteSangpum();
            } else if (ch == 4) {
                //상품수정
                sales.updateSangpum();
            } else if (ch==5) {
                //상품검색
                sales.searchSangpum();
            } else if (ch == 9) {
                break;
                //종료
            } else {
                System.out.println("다시입력");
            }
        }

    }
}
