<%@ page import="mysql.db.SqlDbConnect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String value = request.getParameter("value"); //1자바순, 2학번순
    if (value == null) {
        value="1";
    }


    SqlDbConnect db = new SqlDbConnect();
    Connection conn = db.getConnection();
    PreparedStatement pstmt =null;
    ResultSet rs = null;
    String sql="";

    if(value.equals("java")){

        sql = "select * from student order by java desc";
    } else if (value.equals("num")) {
        sql = "select * from student order by num";
    }



    pstmt = conn.prepareStatement(sql);
    rs = pstmt.executeQuery();
    String s = "[";

    while(rs.next()){
        String num = rs.getString("num");
        String name = rs.getString("name");
        String photo = rs.getString("photo");
        String java = rs.getString("java");
        String spring = rs.getString("spring");

        String json = "{\"num\":%s,\"name\":\"%s\",\"photo\":\"%s\",\"java\":%s,\"spring\":%s} ";

        String fmjson =  String.format(json, num, name, photo, java, spring);
        if(!rs.isLast()){
            fmjson+=",";
        }
        s+=fmjson;
    }
    s+="]";
%>
<%=s%>
