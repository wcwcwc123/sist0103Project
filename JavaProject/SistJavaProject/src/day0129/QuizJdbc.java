package day0129;

import oracleDB.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class QuizJdbc {

    DbConnect db = new DbConnect();
    DecimalFormat decimalFormat = new DecimalFormat("#,##0원");


    public void insertMember() {
        Connection conn = db.getOracle();
        Scanner sc = new Scanner(System.in);

        System.out.print("사원명 입력: ");
        String name = sc.nextLine();

        System.out.print("부서 입력(기획부,인사부,영업부,홍보부): ");
        String buseo = sc.nextLine();

        System.out.print("직급 입력(사원,대리,과장,차장,부장): ");
        String position = sc.nextLine();

        System.out.print("성별 입력(남자,여자): ");
        String gender = sc.nextLine();

        System.out.print("월급여 입력: ");
        int pay = sc.nextInt();
        sc.nextLine();

        System.out.print("보너스 입력: ");
        int bonus = sc.nextInt();
        sc.nextLine();

        String sql = "insert into sawonmember values(seq_smem.nextval,?,?,?,?,?,?,sysdate)";
        PreparedStatement stmt = null;


        try {
            stmt = conn.prepareStatement(sql);
            stmt.setString(1,name);
            stmt.setString(2,buseo);
            stmt.setString(3,position);
            stmt.setString(4, gender);
            stmt.setInt(5, pay);
            stmt.setInt(6, bonus);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(stmt,conn);
        }
    }

    public Collection<Integer> writeMember() {

        String sql = "select * from sawonmember";
        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        Collection<Integer> memList = new ArrayList<Integer>();


        try {
            pstmt = conn.prepareStatement(sql);
            rs =  pstmt.executeQuery();


            System.out.println("사원번호\t사원명\t부서\t\t직급\t\t성별\t\t월급여\t\t\t보너스\t\t입사날짜");
            System.out.println("================================================================================");

            while (rs.next()) {
                int seq = rs.getInt("s_no");
                memList.add(seq);
                System.out.println(seq+"\t"
                        +"\t"+rs.getString("s_name")
                        +"\t"+rs.getString("buseo")
                        +"\t"+rs.getString("position")
                        +"\t\t"+rs.getString("gender")
                        +"\t\t"+decimalFormat.format(rs.getInt("pay"))
                        +"\t\t"+decimalFormat.format(rs.getInt("bonus"))
                        +"\t"+rs.getDate("ipsaday"));

            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(rs, pstmt, conn);
            return memList;
        }

    }
    public void deleteMember() {

        Scanner sc = new Scanner(System.in);
        writeMember();
        System.out.println("삭제할 사원번호 입력");
        int num = sc.nextInt();
        sc.nextLine();

        String sql = "delete from sawonmember where s_no=?";

        Connection conn =db.getOracle();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, num);

            int a = pstmt.executeUpdate();

            if (a == 0) {
                System.out.println(num + "번 사원은 존재하지 않습니다.");
            } else {
                System.out.println(num+"번 사원정보가 삭제되었습니다.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
        }
    }

    public void updateMember() {

        /*수정할 사원번호 입력후 부서 직급  급여 보너스  수정할수있게합니다*/


        Scanner sc = new Scanner(System.in);
        Collection<Integer> memList = new ArrayList<Integer>();


        memList = writeMember();
        System.out.println("수정할 사원번호를 입력하세요");
        int num = sc.nextInt();
        sc.nextLine();
        if (!memList.contains(num)) {
            System.out.println("해당 사원은 존재하지 않습니다.");
            return;
        }

        System.out.println("========"+num+"번 사원 수정중=======");
        System.out.print("부서 입력(기획부,인사부,영업부,홍보부): ");
        String buseo = sc.nextLine();

        System.out.print("직급 입력(사원,대리,과장,차장,부장): ");
        String position = sc.nextLine();

        System.out.print("월급여 입력: ");
        int pay = sc.nextInt();
        sc.nextLine();

        System.out.print("보너스 입력: ");
        int bonus = sc.nextInt();
        sc.nextLine();

        String sql = "update sawonmember set buseo=?,position=?,pay=?,bonus=? where s_no=?";

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,buseo);
            pstmt.setString(2,position);
            pstmt.setInt(3,pay);
            pstmt.setInt(4,bonus);
            pstmt.setInt(5,num);

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            db.dbClose(pstmt, conn);
            System.out.println("===="+num+"번 사원이 수정되었습니다.====");
        }


        System.out.println();
    }
    public void searchMember() {

        Scanner sc = new Scanner(System.in);
        System.out.println("검색할 사원명을 입력하세요");
        String searchName = sc.nextLine();

        String sql = "select * from sawonmember where s_name like ?";

        Connection conn = db.getOracle();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "%%" + searchName + "%%");
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("사원번호\t사원명\t부서\t\t직급\t\t성별\t\t월급여\t\t\t보너스\t\t입사날짜");
                System.out.println("================================================================================");

                System.out.println(rs.getInt("s_no")+"\t"
                        +"\t"+rs.getString("s_name")
                        +"\t"+rs.getString("buseo")
                        +"\t"+rs.getString("position")
                        +"\t\t"+rs.getString("gender")
                        +"\t\t"+decimalFormat.format(rs.getInt("pay"))
                        +"\t\t"+decimalFormat.format(rs.getInt("bonus"))
                        +"\t"+rs.getDate("ipsaday"));
            } else {
                System.out.println("해당 사원이 존재하지 않습니다.");
            }

            while (rs.next()) {
                System.out.println(rs.getInt("s_no")+"\t"
                        +"\t"+rs.getString("s_name")
                        +"\t"+rs.getString("buseo")
                        +"\t"+rs.getString("position")
                        +"\t\t"+rs.getString("gender")
                        +"\t\t"+decimalFormat.format(rs.getInt("pay"))
                        +"\t\t"+decimalFormat.format(rs.getInt("bonus"))
                        +"\t"+rs.getDate("ipsaday"));

            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        QuizJdbc quiz = new QuizJdbc();

        Scanner sc = new Scanner(System.in);
        int ch;


        while (true) {

            System.out.println("1.사원정보입력    2.전체사원출력    3.사원삭제    4.사원수정   5.이름검색    9.시스템종료");
            ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) {
                //입력
                quiz.insertMember();
            } else if (ch == 2) {
                //출력
                quiz.writeMember();
            } else if (ch == 3) {
                //삭제
                quiz.deleteMember();
            } else if (ch == 4) {
                //수정
                quiz.updateMember();
            } else if (ch == 5) {
                //검색
                quiz.searchMember();

            } else if (ch == 9) {
                //종료
                break;
            } else {
                System.out.println("번호를 다시 입력해주세요");
            }
        }

    }
}
