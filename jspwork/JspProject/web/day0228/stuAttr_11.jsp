<%@ page import="java.util.Vector" %>
<%@ page import="test.Student" %>
<%@ page import="javax.servlet." %>

<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-28
  Time: 오후 2:40
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
    <h3>request에 Vector 저장후 불러오는 모습</h3>
<%
    Vector<Student> list = new Vector<>();
    list.add(new Student("이미영", "강남구", 88));
    list.add(new Student("이영자", "서초구", 99));
    list.add(new Student("김미영", "강남구", 87));
    list.add(new Student("이소라", "영등포구", 77));
    list.add(new Student("배윤영", "부산시", 66));

    //데이터 vector를 request에 저장
    request.setAttribute("list", list);


    //페이지이동2:forward(url주소 안바뀌) redirect(url주소 바뀜)
    //<jsp:>태그이동
    response.sendRedirect("stuRedirect_10.jsp");
%>

</body>
</html>
