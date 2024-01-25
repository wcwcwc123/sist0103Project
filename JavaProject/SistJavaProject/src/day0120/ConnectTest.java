package day0120;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectTest {

    static final String URL="jdbc:oracle:thin:@localhost:1521:XE";

    public void connectSawon() {
        Connection conn = null;	// Connection: 연결
        Statement stmt = null; // Statement: 오라클에 sql문 전송해줌
        ResultSet rs = null; // ResultSet: sql에서 만들어진 객체들의 레코드(테이블)을 읽어서 자바로 가져옴

        String sql="select * from sawon order by num";


        try {
            // Connection 연결
            conn=DriverManager.getConnection(URL, "c##stud", "a1234");

            // Statement 연결, createStatement():sql문 전달해주는 메서드
            stmt=conn.createStatement();

            // ResultSet 연결, sql문 전달
            rs=stmt.executeQuery(sql);

            // 여러 줄을 가져올 때는 while문으로 가져온다
            // rs.next(): 다음 데이터로 이동하면서 true 반환, 더 이상 데이터가 없으면 false 반환
            while(rs.next()) {
                // DB로부터 데이터 가져오기
                int num = rs.getInt("num"); // int num = rs.getInt(1);
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String buseo = rs.getString("buseo");
                int pay = rs.getInt("pay");

                System.out.println(num+"\t"+name+"\t"+gender+"\t"+buseo+"\t"+pay);
            }

            System.out.println("오라클 드라이버 연결 성공!");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            System.out.println("오라클 드라이버 연결 실패!!");
        } finally {

            try {
                if(rs!=null)
                    rs.close();
                if(stmt!=null)
                    stmt.close();
                if(conn!=null)
                    conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void connectShop() {
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;

        String sql="select c2.idx, c2.num, s.sangpum, s.color, c2.cnt, c2.guipday from shop s, cart2 c2 where s.num=c2.num";

        try {
            conn=DriverManager.getConnection(URL, "c##stud", "a1234");
            if (conn != null) {
                System.out.println("오라클 성공!!");
            }

            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            System.out.println("** 회원 장바구니 리스트 **");
            System.out.println("주문번호\t상품번호\t상품명\t색상\t구입개수\t구입날짜");
            System.out.println("-----------------------------------------------------------------");

            /*while(rs.next()) {
                int idx=rs.getInt("idx");
                int num=rs.getInt("num");
                String sangpum=rs.getString("sangpum");
                String color=rs.getString("color");
                int cnt=rs.getInt("cnt");
                String guipday=rs.getString("guipday");

                System.out.println(idx+"\t"+num+"\t"+sangpum+"\t"+color+"\t"+cnt+"\t"+guipday);
            }*/
            while (rs.next()) {
                System.out.println(rs);
                System.out.println(rs.getClass());
            }


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("오라클 실패..");
        } finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    public void sawonRead() {
        //부서별 인원수 평균급여
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "select buseo,count(*) cnt, round(avg(pay),0) pay from sawon group by buseo";

        try {
            conn = DriverManager.getConnection(URL, "c##stud", "a1234");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("\t[부서별 평균 인원 및 급여 구하기]");
            System.out.println();
            System.out.println("부서명\t인원수\t평균급여");
            System.out.println("----------------------------");
            while (rs.next()) {
                String buseo = rs.getString("buseo");
                int count = rs.getInt("cnt");
                int pay = rs.getInt("pay");

                System.out.println(buseo+"\t"+count+"명\t"+pay+"원");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ConnectTest ct = new ConnectTest();
        //ct.connectSawon();
        ct.connectShop();
        //ct.sawonRead();
    }
}