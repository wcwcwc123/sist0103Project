<%@ page import="data.dao.MemberDao" %>
<%@ page import="org.json.simple.JSONObject" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-21
  Time: 오전 11:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String nums[] = request.getParameterValues("nums");

    MemberDao dao = new MemberDao();
    int delCount = dao.delteBatchMembers(nums);

    JSONObject ob = new JSONObject();

    if (delCount > 0) {
        ob.put("success", "true");
    } else {
        ob.put("success", "false");
    }

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());
%>