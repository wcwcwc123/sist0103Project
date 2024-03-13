<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="uploadboard.data.UploadBoardDto" %>
<%@ page import="java.util.List" %>
<%@ page import="uploadboard.data.UploadBoardDao" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <title>Title</title>
    <style>
        .board {
            display: flex;
            flex-wrap: wrap;
            justify-content: space-between;
            margin-left: -15px;
            margin-right: -15px;
        }

        .post {
            flex: 0 0 calc(33.333% - 30px); /* Adjusted to fit 3 items per row */
            margin: 15px;
            border: 1px solid #ddd;
            border-radius: 5px;
            overflow: hidden;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, .1);
        }

        .post:hover {
            box-shadow: 0 5px 15px rgba(0, 0, 0, .2);
        }

        .post-image {
            width: 100%; /* Image width to match post width */
            height: 200px; /* Fixed image height */
            object-fit: cover; /* This will make sure the image covers the area, and is not stretched */
            display: block;
        }

        .post-details {
            padding: 15px;
        }

        .post-title {
            margin: 0;
            font-size: 1.2em;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }

        .post-author,
        .post-date,
        .post-views {
            font-size: 0.9em;
            margin-bottom: 5px;
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>
<body>
<%
    UploadBoardDao dao = new UploadBoardDao();
    List<UploadBoardDto> list = dao.getAllDatas();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<button type="button" class="btn btn-info" onclick="location.href='addForm.jsp'">
    게시글 추가
</button>
<br><br>
<h6 class="alert alert-info">총 <%= list.size() %>개의 게시글이 있습니다.</h6>
<div class="board">
    <%
        for (UploadBoardDto dto : list) {
    %>
    <div class="post" onclick="location.href='content.jsp?num=<%=dto.getNum() %>'" style="cursor: pointer">
        <img class="post-image" src="../save/<%=dto.getImgname()%>" alt="게시글 이미지" >
        <div class="post-details">
            <h2 class="post-title"><%=dto.getSubject()%></h2>
            <p class="post-author">작성자: <%=dto.getWriter()%></p>
            <p class="post-date">작성일: <%=sdf.format(dto.getWriteday())%></p>
            <p class="post-views">조회: <%=dto.getReadcount()%></p>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
