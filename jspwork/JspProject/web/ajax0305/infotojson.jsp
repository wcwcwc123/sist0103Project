<%@ page import="mysql.db.SqlDbConnect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-05
  Time: AM 10:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%

  SqlDbConnect db = new SqlDbConnect();
  Connection conn = db.getConnection();
  PreparedStatement pstmt = null;
  ResultSet rs = null;

  String sql = "select * from info order by num";
  String s = "[";

  pstmt = conn.prepareStatement(sql);
  rs = pstmt.executeQuery();

  while(rs.next()) {
    String num = rs.getString("num");
    String name = rs.getString("name");
    String hp = rs.getString("hp");
    String age = rs.getString("age");
    String photo = rs.getString("photo");

    String json = "{ \"num\": %s,\"name\": \"%s\",\"hp\":\"%s\",\"age\":%s,\"photo\":\"%s\"}"
            ;
    String fmjson = String.format(json, num, name, hp, age, photo);

    if (!rs.isLast()) {
      fmjson += ",";
    }

    s += fmjson;
  }
  s+="]";
%>
<%=s%>