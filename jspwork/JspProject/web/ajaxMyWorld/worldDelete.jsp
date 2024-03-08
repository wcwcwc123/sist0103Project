<%@ page import="myworld.model.WorldDao" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="myworld.model.WorldDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-08
  Time: 오전 9:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String num = request.getParameter("num");

    WorldDao dao = new WorldDao();
    WorldDto dto = dao.getOneData(num);

    dao.deleteWorld(num);

    JSONObject ob = new JSONObject();
    ob.put("num", num);
    ob.put("status", "delete_success");
    ob.put("writer",dto.getWriter());
    ob.put("content", dto.getContent());


    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());

%>

