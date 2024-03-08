<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="myworld.model.WorldDao" %>
<%@ page import="myworld.model.WorldDto" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-08
  Time: 오전 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String num = request.getParameter("num");
    String writer = request.getParameter("writer");
    String content = request.getParameter("content");
    String avata = request.getParameter("avata");

    WorldDao dao = new WorldDao();
    WorldDto dto = new WorldDto();

    dto.setNum(num);
    dto.setWriter(writer);
    dto.setContent(content);
    dto.setAvata(avata);

    dao.updateWorld(dto);

    LocalDateTime now = LocalDateTime.now();
    // 포맷 지정
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    // 포맷에 맞춰 출력
    String formattedDateTime = now.format(formatter);



    JSONObject ob = new JSONObject();
    ob.put("status","update success");
    ob.put("num", dto.getNum());
    ob.put("writer", dto.getWriter());
    ob.put("content", dto.getWriter());
    ob.put("avata", dto.getAvata());
    ob.put("time",formattedDateTime);

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());
%>
