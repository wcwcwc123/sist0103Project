<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-29
  Time: 오전 9:21
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
<%--최종학력grade,컴퓨터언어Lang,같은조like,키height,몸무게weight,날짜ipsaday--%>
    <%
        request.setCharacterEncoding("utf-8");

        String grade = request.getParameter("grade");
        String[] lang = request.getParameterValues("Lang");
        String person = request.getParameter("like");
        String height = request.getParameter("height");
        String weight = request.getParameter("weight");
        String ipsaday = request.getParameter("ipsaday");
    %>
<h4><%=grade%></h4>

<%
    if(lang==null){
%>      <h4>언어 없음</h4>
<%    }else{
        for (int i = 0; i < lang.length; i++) {
%>
            [<%=lang[i]%>]
<%
        }
    }
%>
<h4><%=person%></h4>
<h4><%=height%></h4>
<h4><%=weight%></h4>
<h4><%=ipsaday%></h4>


</body>
</html>
