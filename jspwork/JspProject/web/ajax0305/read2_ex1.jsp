<?xml version="1.0" encoding="UTF-8" ?>
<%@ page contentType="text/xml;charset=UTF-8" language="java" %>
<%
    String name = request.getParameter("name");
    String hp = request.getParameter("hp");
    System.out.println("#read2_ex1");
    System.out.println("name: " + name);
    System.out.println("hp:" + hp);
%>
<data>
    <name><%=name%></name>
    <hp><%=hp%></hp>
</data>