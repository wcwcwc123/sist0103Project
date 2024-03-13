<%@ page import="ajaxboard.model.AjaxBoardDao" %>
<%@ page import="ajaxboard.model.AjaxBoardDto" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-11
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    String num= request.getParameter("num");

    AjaxBoardDao dao = new AjaxBoardDao();
    AjaxBoardDto dto = dao.deleteBoard(num);

    JSONObject ob = new JSONObject();
    ob.put("result","delete-success");
    ob.put("writer", dto.getWriter());
    ob.put("subject", dto.getSubject());
    ob.put("content", dto.getContent());

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());

%>
