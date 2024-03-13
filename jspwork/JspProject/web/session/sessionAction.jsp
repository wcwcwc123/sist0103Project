<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오전 9:39
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
    request.setCharacterEncoding("UTF-8");

    //세션이 있는지 확인,확인후 없으면 선물 꽝!!
    String msg = (String)session.getAttribute("msg");
    String gift = request.getParameter("gift");

    if (msg == null || !msg.equals("happy")) {
        %>
<h3 style="color: red;">시간초과로 꽝입니다</h3>
<%}else
{
    %>
<h3 style="color: red">축하합니다 <%=gift%> 획득</h3>
<%}%>


</body>
</html>
