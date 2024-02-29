package oracleDB;

import java.sql.*;

public class DbConnect {

    static final String ORACLEDRIVER="oracle.jdbc.OracleDriver";
    static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";

    public DbConnect() {
        try {
                Class.forName(ORACLEDRIVER);
                Class.forName("oracle.jdbc.OracleDriver");
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
            conn=DriverManager.getConnection(ORACLE_URL, "system", "1234");
            System.out.println("oracle success");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("oracle failed: "+e.getMessage());
        }


        if (conn == null) {
            System.out.println("conn is null");
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



}
