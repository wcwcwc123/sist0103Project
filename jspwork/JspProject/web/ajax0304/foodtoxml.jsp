<?xml version="1.0" encoding="UTF-8" ?>
<%@ page import="mysql.db.SqlDbConnect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>



<data>
    <%
        SqlDbConnect db = new SqlDbConnect();
        Connection conn = db.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "select * from food order by num";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while(rs.next()){
                String num = rs.getString("num");
                String foodname = rs.getString("foodname");
                String foodphoto = rs.getString("foodphoto");
                String price = rs.getString("price");
                String cnt = rs.getString("cnt");%>
                <food num="<%=num%>">
                    <foodname><%=foodname%></foodname>
                    <foodphoto><%=foodphoto%></foodphoto>
                    <price><%=price%></price>
                    <cnt><%=cnt%></cnt>
                </food>
    <%
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            db.dbClose(rs, pstmt, conn);
        }
    %>
</data>

