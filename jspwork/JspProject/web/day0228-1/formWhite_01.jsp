
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-28
  Time: 오후 3:11
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
    request.setCharacterEncoding("utf-8"); //한글깨짐방지post

    String name = request.getParameter("name");
    String pass = request.getParameter("pass");
    String license = request.getParameter("cblic");

%>

<h3 class="alert alert-danger">결과값 출력</h3>
    이름: <%=name%> <br>
    비밀번호: <%=pass%> <br>
    운전면허: <%=license==null?"없음":"있음"%>

</body>
</html>
