<%@ page import="org.json.simple.JSONObject" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String s1 = request.getParameter("s1");
    String s2 = request.getParameter("s2");
    String s3 = request.getParameter("s3");
    String photo = request.getParameter("foodphoto");
    String fname = request.getParameter("foodname");

    int total = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
    double avg = total / 3.0;

    JSONObject ob = new JSONObject();
    ob.put("foodname", fname);
    ob.put("foodphoto","../image/Food/"+photo+".jpg");
    ob.put("total",total);
    ob.put("avg", avg);

    // JSON 형식의 결과 전송
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(ob.toString());
%>

