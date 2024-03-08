<%@ page import="simpleguest.model.GuestDto" %>
<%@ page import="simpleguest.model.GuestDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-08
  Time: 오후 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String image = request.getParameter("image");
    String nickname = request.getParameter("nickname");
    String pass = request.getParameter("pass");
    String content = request.getParameter("content");

    if (image == null || nickname == null || pass == null) {
        response.sendRedirect("guestList.jsp");
    }else{

        GuestDao dao = new GuestDao();
        GuestDto dto = new GuestDto();

        dto.setImage(image);
        dto.setNickname(nickname);
        dto.setPass(pass);
        dto.setContent(content);

        dao.insertGuest(dto);

        response.sendRedirect("guestList.jsp");

    }

%>