package mysql.db;

import java.sql.*;

public class DbConnect {

    String url = "jdbc:mysql://localhost:3306/coffee";
    String userName = "root";
    String password = "1234";

    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("드라이버성공");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            //e.printStackTrace();
            System.out.println("오라클드라이버 실패"+e.getMessage());
        }
    }
    public Connection getConnection()
    {
        Connection conn=null;

        try {
            conn=DriverManager.getConnection(url, userName, password);
            System.out.println("sql success");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("sql failed: "+e.getMessage());
        }


        return conn;
    }

    //close 총 4개 오버로딩
    public void dbClose(ResultSet rs,Statement stmt,Connection conn)
    {

        try {
            if(rs!=null) rs.close();
            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dbClose(Statement stmt,Connection conn)
    {

        try {

            if(stmt!=null) stmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dbClose(ResultSet rs,PreparedStatement pstmt,Connection conn)
    {

        try {
            if(rs!=null) rs.close();
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void dbClose(PreparedStatement pstmt,Connection conn)
    {

        try {

            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }




    public static void main(String[] args) throws SQLException {

        DbConnect sqldb = new DbConnect();
        Connection conn = sqldb.getConnection();

        PreparedStatement psmt = null;

        for (int i = 0; i < 12; i++) {
            String sql = "insert into food(foodname,foodphoto,price,cnt) " +
                    "values('푸드"+(i+1)+ "','../image/Food/"+(i+1)+".jpg','12000','"+(i*5)+"')";
            psmt = conn.prepareStatement(sql);
            psmt.execute();
        }
        sqldb.dbClose(psmt,conn);




//        Connection connection = DriverManager.getConnection(url, userName, password);
//        PreparedStatement psmt = null;
//        for (int i = 0; i < 50; i++) {
//            String sql = "insert into team(name,driver,addr,writeday) " +
//                    "values('김신아"+(i+1)+"','있음','경기도 하남시"+(i+1)+"',now())";
//            psmt = connection.prepareStatement(sql);
//            psmt.execute();
//
//        }
//        psmt.close();
//        connection.close();
    }
}