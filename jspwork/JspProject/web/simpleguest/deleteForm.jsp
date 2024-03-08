<%@ page import="simpleguest.model.GuestDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-08
  Time: 오후 3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String num = request.getParameter("num");

    GuestDao dao = new GuestDao();
    dao.deleteGuest(num);

    response.sendRedirect("guestList.jsp");
%>
