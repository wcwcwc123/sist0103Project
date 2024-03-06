<%@ page import="team.model.TeamDao" %>
<%@ page import="team.model.TeamDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-06
  Time: AM 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String name = request.getParameter("name");
    String addr = request.getParameter("addr");

//    String driver = request.getParameter("driver");

    String isDriver = (request.getParameter("driver")==null)?"false":"true";

    TeamDao dao = new TeamDao();
    TeamDto dto = new TeamDto();
    dto.setName(name);
    dto.setAddr(addr);
    dto.setDriver(isDriver);

    dao.insertTeam(dto);

    System.out.println(name);
    System.out.println(addr);
    System.out.println(isDriver);

    response.sendRedirect("addForm.jsp");
%>