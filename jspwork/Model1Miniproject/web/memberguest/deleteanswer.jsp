<%@ page import="data.dao.AnswerGuestDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-26
  Time: 오후 12:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String idx=request.getParameter("idx");
    AnswerGuestDao dao=new AnswerGuestDao();
    dao.deleteAnswer(idx);
%>