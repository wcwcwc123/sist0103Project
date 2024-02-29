<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-28
  Time: 오후 3:33
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

    String city1 = request.getParameter("city");
    String[] city2 = request.getParameterValues("city2");

%>

<h4 class="alert alert-info">
    1순위지역: <%=city1%> <br><br>
    2순위지역:
    <%
        if (city2 == null) {
    %>
        <font color="red">2순위는 선택안함</font>
        <%}else{
        for(int i=0;i<city2.length;i++){
            %>
        [<%=city2[i]%>] %nbsp;
        <%}%>
        <b>총 <%=city2.length%>개 지역을 선택함</b>
        <%}
%>
</h4>
</body>
</html>
