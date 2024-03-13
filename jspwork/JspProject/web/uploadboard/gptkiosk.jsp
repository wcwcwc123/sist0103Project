<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오후 12:42
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
        body, html {
            height: 100%;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .container {
            display: flex;
            flex-direction: column;
            height: 100%;
        }

        .header {
            display: flex;
            justify-content: space-between;
            padding: 1em;
            background-color: #f3f3f3;
            align-items: center;
        }

        .nav-menu {
            display: flex;
        }

        .nav-item {
            padding: 0.5em 1em;
            text-decoration: none;
            color: black;
        }

        .nav-item:not(:last-child) {
            border-right: 1px solid #ddd;
        }

        .search input[type="search"] {
            padding: 0.5em;
        }

        .main-content {
            flex-grow: 1;
            padding: 1em;
            display: flex;
            flex-wrap: wrap;
            gap: 1em;
        }

        .menu-item {
            flex: 1 1 20%; /* Adjust the number based on your layout preference */
            height: 150px; /* Adjust the height based on your preference */
            background-color: #eee;
            border-radius: 10px;
        }

        .menu-item.large {
            flex: 1 1 40%;
        }

        .footer {
            display: flex;
            justify-content: space-around;
            background-color: #ddd;
            padding: 1em;
        }

        .footer-item {
            flex: 1;
            text-align: center;
            padding: 0.5em;
            background-color: #ccc;
            margin: 0 0.5em;
            border-radius: 5px;
        }

        .signature {
            text-align: center;
            padding: 0.5em;
            background-color: #eee;
            font-style: italic;
        }

    </style>
</head>
<body>
<div class="container">
    <header class="header">
        <nav class="nav-menu">
            <a href="#" class="nav-item">메뉴</a>
            <a href="#" class="nav-item">음료</a>
            <a href="#" class="nav-item">사이드</a>
            <a href="#" class="nav-item">세트</a>
        </nav>
        <div class="search">
            <input type="search" placeholder="검색">
        </div>
    </header>

    <section class="main-content">
        <div class="menu-item large"></div>
        <div class="menu-item"></div>
        <div class="menu-item"></div>
        <div class="menu-item"></div>
        <div class="menu-item"></div>
        <div class="menu-item"></div>
    </section>

    <footer class="footer">
        <div class="footer-item">장바구니</div>
        <div class="footer-item">결제</div>
        <div class="footer-item">취소</div>
        <div class="footer-item">콜센터</div>
        <div class="footer-item">고객센터</div>
    </footer>

    <div class="signature">고객님</div>
</div>
</body>
</html>
