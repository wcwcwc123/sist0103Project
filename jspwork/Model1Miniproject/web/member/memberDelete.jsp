<%@ page import="data.dao.MemberDao" %>
<%@ page import="data.dto.MemberDto" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-21
  Time: 오전 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String num = request.getParameter("num");
    MemberDao dao = new MemberDao();
    MemberDto dto = dao.getOneMember(num); // only id,name

    System.out.println("<memberDelete> num: " + num);

    JSONObject ob = new JSONObject();

    if (dao.deleteMember(num)>0) {
        ob.put("success", "true");
        ob.put("name", dto.getName());
        ob.put("id", dto.getId());
        ob.put("num", num);
    } else {
        ob.put("success", "false");
    }

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());
%>