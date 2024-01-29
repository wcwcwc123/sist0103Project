package oracleDB;

import java.sql.*;

public class DbConnect {

    //url
    static final String ORACLE_DB = "jdbc:oracle:thin:@localhost:1521:XE";
    static String username = "woochan";
    static String password = "a1234";

    public Connection getOracle() {
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(ORACLE_DB, username, password);
        } catch (SQLException e) {
            System.out.println("getOracle 로컬 오라클DB연결 실패");
        }
        return conn;
    }

    //close 메소드 총4개
    public void dbClose(ResultSet rs, Statement stmt, Connection conn) {

        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dbClose(Statement stmt, Connection conn) {

        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dbClose(ResultSet rs, PreparedStatement stmt, Connection conn) {

        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void dbClose(PreparedStatement stmt, Connection conn) {

        try {
            if (stmt != null) stmt.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

    }

}
