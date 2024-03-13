<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오전 9:29
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
    //세션 저장하는법
    session.setAttribute("msg", "happy day!!");
    session.setMaxInactiveInterval(60); //60초
%>

<h3>세션값 얻기</h3>
세션값: <%=session.getAttribute("msg")%><br>
세션유지시간: <%=session.getMaxInactiveInterval()%>초<br>
세션생성시간: <%=session.getCreationTime()%><br>
세션생성시간: <%=new Date(session.getCreationTime())%>



</body>
</html>
