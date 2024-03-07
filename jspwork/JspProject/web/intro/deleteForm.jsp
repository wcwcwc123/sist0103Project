<%@ page import="intro.model.IntroDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-07
  Time: 오전 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String num = request.getParameter("num");

    IntroDao dao = new IntroDao();
    dao.delteIntro(num);

    response.sendRedirect("introList.jsp");

%>