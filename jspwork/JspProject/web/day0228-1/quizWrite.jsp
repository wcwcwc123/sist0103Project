<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-28
  Time: 오후 4:05
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
    String hiredate = request.getParameter("hiredate");
    String menu = request.getParameter("menu");
    String []hopemenu = request.getParameterValues("hopemenu");
%>
<table class="table table-bordered" style="width: 400px">
    <tr>
        <td >사원명</td>
        <td><%=name%></td>
    </tr>
    <tr>
        <td>입사날짜</td>
        <td><%=hiredate%></td>
    </tr>
    <tr>
        <td style="vertical-align: center">오늘 선택 점심메뉴</td>
        <td><img src="<%=menu%>" alt="" width="100"></td>
    </tr>
    <tr>
        <td>건의하는메뉴</td>
        <td><%
            if(hopemenu==null){
        %>
            <font>원하는 메뉴 없음</font>
            <%
            }else{
                for (int i = 0; i < hopemenu.length; i++) {
            %>      [<%=hopemenu[i]%>]&nbsp;
            <%}
            }
            %></td>
    </tr>
</table>

<div style="border: 2px black solid;width: 400px; ">
<h4>사원명: <%=name%></h4>
<h4>입사날짜: <%=hiredate%></h4>
<h4>오늘 선택 점심메뉴: <img src="<%=menu%>" alt="" width="100"></h4>
<h4>건의하는메뉴:
<%
    if(hopemenu==null){
%>
     <font>원하는 메뉴 없음</font>
    <%
    }else{
        for (int i = 0; i < hopemenu.length; i++) {
      %>      [<%=hopemenu[i]%>]&nbsp;
        <%}
    }
%>
</h4>
</div>

</body>
</html>
