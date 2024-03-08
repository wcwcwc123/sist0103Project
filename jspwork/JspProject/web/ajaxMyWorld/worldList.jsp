<%@ page import="myworld.model.WorldDao" %>
<%@ page import="myworld.model.WorldDto" %>
<%@ page import="java.util.List" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-07
  Time: 오후 12:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    WorldDao dao = new WorldDao();

    //목록
    List<WorldDto> list = dao.getAllMyWorld();

    JSONArray arr = new JSONArray();

    for (WorldDto dto : list) {

        JSONObject ob = new JSONObject();
        ob.put("num", dto.getNum());
        ob.put("writer", dto.getWriter());
        ob.put("content", dto.getContent());
        ob.put("avata", dto.getAvata());
        ob.put("writeday", dto.getWriteday().toString());

        arr.add(ob);
    }

    // JSON 형식의 결과 전송
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(arr.toString());

%>
<%--<%=arr.toString()%>--%>
