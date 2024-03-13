<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="uploadboard.data.UploadBoardDto" %>
<%@ page import="java.util.List" %>
<%@ page import="uploadboard.data.UploadBoardDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오후 4:09
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
        .board {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
        }

        .post {
            width: calc(20% - 30px);
            margin: 15px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .1);
            border: 1px solid #ddd;
            border-radius: 5px; /* 앨범 테두리에 둥근 모서리 추가 */
            overflow: hidden;
            background-color: #fff;
            transition: box-shadow 0.3s ease-in-out;
        }

        .post:hover {
            box-shadow: 0 5px 15px rgba(0, 0, 0, .2); /* 호버 시에 그림자 효과를 줍니다 */
        }

        .post-image {
            width: 100%; /* 이미지의 너비를 포스트 너비와 맞춤 */
            height: auto;
            display: block;
        }

        .post-details {
            padding: 15px;
        }

        /* 기타 스타일은 그대로 유지합니다. */

    </style>
</head>
<body>
<%
    UploadBoardDao dao = new UploadBoardDao();
    List<UploadBoardDto> list = dao.getAllDatas();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<button type="button" class="btn btn-info" onclick="location.href='addForm.jsp'">
    게시글추가
</button>
<br><br>
<h6 class="alert alert-info">총 <%=list.size()%>개의 게시글이 있습니다</h6>
<div class="board">
    <%
        for (int i = 0; i < list.size(); i++) {
            UploadBoardDto dto = list.get(i);
    %>
    <div class="post">
        <img class="post-image" src="../save/<%=dto.getImgname()%>" alt="게시글 이미지" style="width: 100px">
        <div class="post-details">
            <h2 class="post-title"><%=dto.getSubject()%></h2>
            <p class="post-author">작성자: <%=dto.getWriter()%></p>
            <p class="post-date">작성일: <%=sdf.format(dto.getWriteday())%></p>
            <p class="post-views">조회: <%=dto.getReadcount()%></p>
        </div>
    </div>
    <%}%>
</div>



</body>
</html>
