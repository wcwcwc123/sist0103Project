<%@ page import="ajaxboard.model.AjaxBoardDto" %>
<%@ page import="ajaxboard.model.AjaxBoardDao" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-11
  Time: 오후 4:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");

    String writer = request.getParameter("writer");
    String subject = request.getParameter("subject");
    String content = request.getParameter("content");
    String avata = request.getParameter("avata");
    String num = request.getParameter("num");




    AjaxBoardDao dao = new AjaxBoardDao();
    AjaxBoardDto dto = new AjaxBoardDto();

    dto.setWriter(writer);
    dto.setSubject(subject);
    dto.setContent(content);
    dto.setAvata(avata);
    dto.setNum(num);

    dao.updateBoard(dto);

    JSONObject ob = new JSONObject();
    ob.put("writer", dto.getWriter());
    ob.put("subject", dto.getSubject());
    ob.put("content", dto.getContent());
    ob.put("avata", dto.getAvata());

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());
%>
