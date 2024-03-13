<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="ajaxboard.model.AjaxBoardDto" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="ajaxboard.model.AjaxBoardDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-11
  Time: 오후 2:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  request.setCharacterEncoding("UTF-8");
  String num = request.getParameter("num");


  AjaxBoardDao dao = new AjaxBoardDao();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  AjaxBoardDto dto= dao.getData(num);

  JSONObject ob = new JSONObject();

  ob.put("num", dto.getNum());
  ob.put("writer", dto.getWriter());
  ob.put("subject", dto.getSubject());
  ob.put("content", dto.getContent());
  ob.put("avata", dto.getAvata());
  ob.put("writeday", sdf.format(dto.getWriteday()));

  response.setContentType("application/json");
  response.setCharacterEncoding("UTF-8");
  response.getWriter().write(ob.toString());

%>
