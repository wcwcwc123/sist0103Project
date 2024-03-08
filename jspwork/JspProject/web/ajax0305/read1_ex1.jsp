<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-05
  Time: PM 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("name");
    String hp = request.getParameter("hp");
    System.out.println("#read1_ex1");
    System.out.println("name: " + name);
    System.out.println("hp:" + hp);
%>
