<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <style>
        body {
            font-family: 'Noto Sans KR', sans-serif;
            background-color: #f0f0f0; /* 배경 색상 설정 */
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh; /* 전체 화면 높이 */
            margin: 0;
        }
        .welcome-message {
            text-align: center;
            background-color: white;
            padding: 50px;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); /* 상자 그림자 효과 */
        }
        h2 {
            color: #333; /* 제목 색상 */
        }
        .back-button {
            margin-top: 20px; /* 버튼 상단 여백 */
            text-decoration: none; /* 링크 밑줄 제거 */
        }
    </style>

    <title>가입 축하</title>
</head>
<body>
<div class="welcome-message">
    <%
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
    %>
    <h2><%=name%>님 가입 축하드립니다</h2>
    <!-- 버튼 추가 -->
    <a href="/" class="btn btn-primary back-button">확인</a>
</div>

</body>
</html>