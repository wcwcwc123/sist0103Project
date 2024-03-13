<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오전 10:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <title>Title</title>
    <style>
        div.logform {
            width: 500px;
            margin: 0 auto;
            margin-top: 100px;

        }
    </style>
</head>
<%
    String myid = (String) session.getAttribute("idok");
    String saveid = (String) session.getAttribute("saveok");

    boolean save = true;

    if (saveid == null || saveid.equals("no")) {
        myid=""; //아이디 저장을 체크하지 않은경우 아이디 없앤다
        save = false;
    }
%>
<body>
<div class="logform">
    <h2>회원 로그인</h2>
    <form action="loginAction.jsp" method="post">
        <input type="text" value="<%=myid%>" name="id" class="form-control" style="width: 200px;" placeholder="아이디 입력" required>
        <input type="password" name="pass" class="form-control" style="width: 200px;" placeholder="비밀번호 입력" required>
        <button type="submit" class="btn btn-success btn-Lg" style="width: 200px; height: 50px">로그인</button>
        <br>
        <input type="checkbox" name="savechk" <%=(save==true?"checked":"")%>>아이디 저장
    </form>

</div>

</body>
</html>
