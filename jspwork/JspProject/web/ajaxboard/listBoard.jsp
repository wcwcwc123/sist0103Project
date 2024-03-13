<%@ page import="ajaxboard.model.AjaxBoardDao" %>
<%@ page import="ajaxboard.model.AjaxBoardDto" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="oracle.jdbc.driver.json.binary.JsonpOsonArray" %>
<%@ page import="org.json.simple.JSONArray" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-11
  Time: 오전 9:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    AjaxBoardDao dao = new AjaxBoardDao();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    List<AjaxBoardDto> list = new ArrayList<AjaxBoardDto>();

    list = dao.getAllDatas();

    JSONArray array = new JSONArray();

    for (AjaxBoardDto dto : list) {
        JSONObject ob = new JSONObject();

        ob.put("num", dto.getNum());
        ob.put("writer", dto.getWriter());
        ob.put("subject", dto.getSubject());
        ob.put("content", dto.getContent());
        ob.put("avata", dto.getAvata());
        ob.put("writeday", sdf.format(dto.getWriteday()));

        array.add(ob);
    }

    //System.out.println(array.toString());

    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(array.toString());



%>