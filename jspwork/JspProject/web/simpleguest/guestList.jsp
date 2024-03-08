<%@ page import="simpleguest.model.GuestDao" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="simpleguest.model.GuestDto" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-08
  Time: 오후 2:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
          rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <title>Title</title>
    <style>
        span.day{
            float: right;
            color: #bbb;
        }
        div.edit{
            float: right;
        }

    </style>
</head>
<body>
<%
    GuestDao dao = new GuestDao();
    ArrayList<GuestDto> list = dao.getAllDatas();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
%>

<div style="margin: 50px 100px;width: 600px;">
    <button type="button" class="btn btn-info btn-sm"
            onclick="location.href='insertForm.jsp'">글쓰기</button>
    <br><br>

    <%

    for(GuestDto dto:list){
    %>
    <div class="edit" >
        <i class="bi bi-pencil-square" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'"></i>
        <i class="bi bi-trash3" onclick="confirm('삭제하시겠습니까?') ? location.href='deleteForm.jsp?num=<%=dto.getNum()%>':''"></i>
    </div>

    <table class="table table-bordered" style="width: 600px;">
        <tr>
            <td>
                <b>No.<%=dto.getNum()%></b>&nbsp;&nbsp;
                <b><%=dto.getNickname()%></b>
                <span class="day"><%=sdf.format(dto.getWriteday())%></span>
            </td>
        </tr>
        <tr>
            <td>

                <div style="width: 400px;">
                    <img alt="" src="../image/avata/0<%=dto.getImage()%>.png"
                         align="left" hspace="20">
                    <pre> <%=dto.getContent()%></pre>
                </div>

            </td>
        </tr>
    </table>
    <%}%>




</div>

</body>
</html>
