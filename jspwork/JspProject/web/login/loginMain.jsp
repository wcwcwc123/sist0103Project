<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오전 10:13
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
    String loginok = (String) session.getAttribute("loginok");
    if (loginok == null || loginok.equals("")) {
        %>
<jsp:include page="loginForm.jsp"/>
    <%}else{%>
    <jsp:include page="logoutForm.jsp"/>
<%}%>


</body>
</html>
