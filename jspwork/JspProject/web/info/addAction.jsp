<%@ page import="info.model.InfoDto" %>
<%@ page import="info.model.InfoDao" %>
<%@ page import="oracle.db.DbConnect" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-29
  Time: 오전 10:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    String name = request.getParameter("name");
    String addr = request.getParameter("addr");

    //입력데이터를 dto로 묶어서 메소드로 전달

    InfoDto dto = new InfoDto();
    dto.setName(name);
    dto.setAddr(addr);

    System.out.println(dto.getName());
    System.out.println(dto.getAddr());


    //insert메서드로 전달
    InfoDao dao = new InfoDao();
    dao.infoInsert(dto);

    response.sendRedirect("list.jsp");
%>

</body>
</html>
