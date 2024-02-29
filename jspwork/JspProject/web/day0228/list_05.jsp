<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-28
  Time: 오전 11:11
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
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    list.add("yellow");
    list.add("gray");
    list.add("magenta");
    list.add("orange");
    list.add("blue");

    for (String a : list) {
%>
        <div style="width: 100px; height: 50px; background-color:<%=a%>"><%=a%></div>
<%
    }
%>
    <h3>이미지 배열로 출력</h3>

<%
    String[] imgArr = {"1.jpg","10.jpg","11.jpg","12.jpg","5.jpg","6.jpg",
                        "8.jpg","9.jpg","2.jpg"};
    int n =0;
%>
    <table>
<%
    for (int i = 0; i < 3; i++) {
%>
        <tr style="height: 100px">
            <%
                for (int j = 0; j < 3; j++) {
            %>
                    <td>
                        <img src="../image/Food/<%=imgArr[n]%>" alt="">

                    </td>
            <%
                    n++;
                }
            %>
        </tr>
                <%}
            %>
    </table>

    <h2>문제: 연예인사진 20개가 있다 4형5열로 출력해주세요</h2>
<table>
<%
    int a=0;
    for (int row = 1; row <= 4; row++) {
%>
    <tr>
<%
        for (int col = 1; col <= 5; col++) {

            a++;
%>
        <td>
            <img src="../image/연예인사진/<%=a%>.jpg" class="mainimg">
        </td>
<%
        }
%>
    </tr>
    <%}
    %>
</table>
</body>
</html>
