package day0125;

import java.sql.*;

public class ConnectTest {
    static String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
    // Oracle 데이터베이스 URL
    static String jdbcURL = "jdbc:oracle:thin:@localhost:1521:XE";
    // Oracle 데이터베이스 사용자 이름과 암호
    static String username = "c##stud";
    static String password = "a1234";

    public void connectShop() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        String sql = "select idx,c.num,sangpum,color,cnt,guipday from shop s,cart2 c where s.num=c.num;";

        try {
            conn = DriverManager.getConnection(jdbcURL, username, password);
            System.out.println("오라클성공!!!");

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            System.out.println("**회원님 장바구니 리스트**");
            System.out.println("주문번호\t상품번호\t상품명\t색상\t구입갯수\t구입날짜");

            while (rs.next()) {
                int idx = rs.getInt("idx");
                int num = rs.getInt("num");
                String sang = rs.getString("sangpum");
                String color = rs.getString("color");
                int cnt = rs.getInt("cnt");
                String guipday = rs.getString("guipday");

                System.out.println(idx+num+sang+color+cnt+guipday);
            }
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("오라클 실패");
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
        // Oracle JDBC 드라이버 클래스
        ConnectTest ct = new ConnectTest();
        ct.connectShop();

        Connection connection = null;

        ResultSet rs=null;
        Statement stmt = null;



        try {
            // JDBC 드라이버 클래스 로드
            Class.forName(jdbcDriver);
            // 데이터베이스에 연결
            connection = DriverManager.getConnection(jdbcURL, username, password);
            if (connection != null) {
                System.out.println("Oracle 데이터베이스에 성공적으로 연결되었습니다.");
                // 여기에 추가적인 작업을 수행할 수 있습니다.
                /*String sql = "select * from sawon order by num";
                stmt = connection.createStatement();
                rs = stmt.executeQuery(sql);

                while (rs.next()) {
                    int num = rs.getInt("num");
                    String name = rs.getString("name");

                    System.out.println(num + name);
                }*/
                stmt = null;
                rs = null;

                String sql = "select c2.idx,c2.num,s.sangpum,s.color,c2.cnt,c2.guipday from shop s,cart2 c where s.num=c.num;";

                try {
                    connection = DriverManager.getConnection(jdbcURL, username, password);
                    System.out.println("오라클성공!!!");

                    stmt = connection.createStatement();
                    rs = stmt.executeQuery(sql);

                    System.out.println("**회원님 장바구니 리스트**");
                    System.out.println("주문번호\t상품번호\t상품명\t색상\t구입갯수\t구입날짜");

                    while (rs.next()) {
                        int idx = rs.getInt("idx");
                        int num = rs.getInt("num");
                        String sang = rs.getString("sangpum");
                        String color = rs.getString("color");
                        int cnt = rs.getInt("cnt");
                        String guipday = rs.getString("guipday");

                        System.out.println(idx+num+sang+color+cnt+guipday);
                    }
                    System.out.println(rs);
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("오라클 실패");
                }finally {
//                    try {
////                        rs.close();
////                        stmt.close();
////                        connection.close();
//                    } catch (SQLException e) {
//                        e.printStackTrace();
//                    }
                }



            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("데이터베이스 연결에 실패하였습니다.");
            e.printStackTrace();
        } finally {
            // 연결 해제
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}