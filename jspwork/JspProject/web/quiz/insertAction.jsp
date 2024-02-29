<%@ page import="quiz.model.QuizDao" %>
<%@ page import="quiz.model.QuizDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-29
  Time: 오후 4:11
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
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String phone = request.getParameter("phone");
    String driver = request.getParameter("driver");

    QuizDto dto = new QuizDto();
    dto.setName(name);
    dto.setAge(age);
    dto.setPhone(phone);
    dto.setHasDriver(driver==null?"false":"true");

    QuizDao dao = new QuizDao();
    dao.quizInsert(dto);

    response.sendRedirect("list.jsp");
%>
<h4><%=name%></h4>
<h4><%=age%></h4>
<h4><%=phone%></h4>
<h4><%=driver%></h4>


</body>
</html>
