<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오전 10:14
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
    //로그인에 대한 세션값 삭제
    session.removeAttribute("loginok");
    //로그인메인으로 이동.. 항상 메인을 통해서 이동하게끔
    response.sendRedirect("loginMain.jsp");
%>

</body>
</html>
