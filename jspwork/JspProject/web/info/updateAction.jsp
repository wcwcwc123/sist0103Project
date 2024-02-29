<%@ page import="info.model.InfoDto" %>
<%@ page import="info.model.InfoDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Gowun+Dodum&family=IBM+Plex+Sans+KR&family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    String name = request.getParameter("name");
    String addr = request.getParameter("addr");
    String num = request.getParameter("num");

    //입력데이터를 dto로 묶어서 메소드로 전달

    InfoDto dto = new InfoDto();
    dto.setNum(num);
    dto.setName(name);
    dto.setAddr(addr);

    System.out.println(num+name+addr);

    //insert메서드로 전달
    InfoDao dao = new InfoDao();
    dao.infoUpdate(dto);

    response.sendRedirect("list.jsp");
%>
</body>
</html>