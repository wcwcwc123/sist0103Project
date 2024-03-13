<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오후 12:36
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
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
        }

        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            max-width: 500px;
            margin: auto;
        }

        .input-group {
            margin-bottom: 20px;
        }

        .input-group label {
            display: block;
            margin-bottom: 5px;
            color: #333;
        }

        .input-group input[type="text"],
        .input-group textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .radio-group {
            display: flex;
            justify-content: space-between;
        }

        .radio-group input[type="radio"] {
            margin-right: 10px;
        }

        .radio-group label {
            margin-right: 20px;
        }

        .button-group {
            display: flex;
            justify-content: space-between;
        }

        .button-group button {
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .button-group button[type="submit"] {
            background-color: #4CAF50;
            color: white;
        }

        .button-group button[type="button"] {
            background-color: #f0ad4e;
            color: white;
        }

        textarea {
            height: 100px;
        }
    </style>
</head>
<body>
<form class="form-container">
    <div class="input-group">
        <label for="name">전성자</label>
        <input type="text" id="name" name="name">
    </div>

    <div class="input-group">
        <label for="title">제목</label>
        <input type="text" id="title" name="title">
    </div>

    <div class="input-group">
        <label>사진올리는곳</label>
        <div class="radio-group">
            <input type="radio" id="option1" name="photo-upload">
            <label for="option1">파일 선택</label>
            <input type="radio" id="option2" name="photo-upload">
            <label for="option2">선택된 파일 없음</label>
        </div>
    </div>

    <div class="input-group">
        <label for="memo">비밀번호</label>
        <textarea id="memo" name="memo"></textarea>
    </div>

    <div class="button-group">
        <button type="submit">저장하기</button>
        <button type="button">목록보기</button>
    </div>
</form>


</body>
</html>
