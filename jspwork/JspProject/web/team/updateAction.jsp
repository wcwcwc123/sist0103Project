<%@ page import="team.model.TeamDto" %>
<%@ page import="info.model.InfoDto" %>
<%@ page import="info.model.InfoDao" %>
<%@ page import="team.model.TeamDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-06
  Time: PM 12:40
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
    //한글엔코딩
    request.setCharacterEncoding("utf-8");

    //데이타 읽어서 dto담기
    String num=request.getParameter("num");
    String name=request.getParameter("name");
    String addr=request.getParameter("addr");
    String isDriver = (request.getParameter("driver")==null)?"false":"true";

    System.out.println(num);
    System.out.println(name);
    System.out.println(addr);
    System.out.println(isDriver);

    TeamDao dao = new TeamDao();
    TeamDto dto = new TeamDto();

    dto.setName(name);
    dto.setAddr(addr);
    dto.setDriver(isDriver);
    dto.setNum(num);

    dao.updateTeam(dto);

    response.sendRedirect("teamList.jsp");



%>

</body>
</html>
