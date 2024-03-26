<%@ page import="java.net.URLEncoder" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    String email=request.getParameter("email1")+"@"+request.getParameter("email2");
    String addr = "[" + request.getParameter("post_code") + "]" + request.getParameter("roadAddress") + " " +
            request.getParameter("detailAddress") + request.getParameter("extraAddress");

    String hp1 = request.getParameter("hp1");
    String hp2 = request.getParameter("hp2");
    String hp3 = request.getParameter("hp3");
    String hp = hp1 + "-" + hp2 + "-" + hp3;
%>
<jsp:useBean id="dao" class="data.dao.MemberDao"/>
<jsp:useBean id="dto" class="data.dto.MemberDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
    dto.setEmail(email);
    dto.setAddr(addr);
    dto.setHp(hp);

    dao.insertMember(dto);

    String name = dto.getName();
    String encodedName = URLEncoder.encode(name, "UTF-8");

    //일단은 리스트..가입성공페이지로 바꿀예정
    response.sendRedirect("./gaipSuccess.jsp?name="+encodedName);
%>
</body>
</html>