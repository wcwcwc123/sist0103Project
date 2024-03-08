<%@ page import="myworld.model.WorldDao" %>
<%@ page import="myworld.model.WorldDto" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-07
  Time: 오후 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    WorldDao dao = new WorldDao();

    request.setCharacterEncoding("UTF-8");

    //데이터 읽기
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");
    String avata = request.getParameter("avata");

    System.out.println(writer+content+avata);

    WorldDto dto = new WorldDto();
    dto.setWriter(writer);
    dto.setContent(content);
    dto.setAvata(avata);

    dao.insertWorld(dto);

    JSONObject ob = new JSONObject();
    ob.put("writer", dto.getWriter());
    ob.put("content",dto.getContent());
    ob.put("avata", dto.getAvata());

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());
%>


