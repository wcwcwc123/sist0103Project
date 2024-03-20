<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-20
  Time: 오후 4:00
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
    <%
        //프로젝트 경로
        String root=request.getContextPath();
    %>
    <link
            rel="stylesheet"
            href="https://unpkg.com/swiper/swiper-bundle.min.css"
    />
    <style>
        body{
            margin: 0;
            padding: 0;
        }

        header {
            display: flex;
            justify-content: space-between;
            padding: 20px;
            background-color: #f8f9fa;
        }

        nav ul {
            list-style-type: none;
            padding: 0;
            display: flex;
        }

        nav ul li {
            padding: 10px;
        }

        .slider {
            position: relative;
        }

        .slider img {
            width: 100%;
            display: block;
        }

        .prev, .next {
            cursor: pointer;
            position: absolute;
            top: 50%;
            transform: translateY(-50%);
            padding: 16px;
            color: white;
            font-weight: bold;
            font-size: 24px;
            background-color: rgba(0,0,0,0.6);
            border: none;
        }

        .prev {
            left: 0;
        }

        .next {
            right: 0;
        }
    </style>

</head>
<body>
<header>
    <h1>쇼핑몰 이름</h1>
    <input type="text" placeholder="검색...">
</header>
<nav>
    <ul>
        <li><a href="#">카테고리 1</a></li>
        <li><a href="#">카테고리 2</a></li>
        <li><a href="#">카테고리 3</a></li>
    </ul>
</nav>
<div class="slider">
    <img src="../image/banner-01.png" alt="광고 1" style="width: 100%; height: 400px;">
    <img src="../image/banner-02.png" alt="광고 2" style="display:none;width: 100%; height: 400px;">
    <img src="../image/banner-03.png" alt="광고 3" style="display:none;width: 100%; height: 400px;">
    <!-- 슬라이드 컨트롤 버튼 -->
    <a class="prev" onclick="changeSlide(-1)">❮</a>
    <a class="next" onclick="changeSlide(1)">❯</a>
</div>

<script>
    let slideIndex = -1;
    let timeout;
    showSlides();


    function showSlides() {
        let slides = document.getElementsByClassName("slider")[0].getElementsByTagName("img");
        for (let i = 0; i < slides.length; i++) {
            slides[i].style.display = "none";
        }

        slideIndex+=1
        slideIndex = slideIndex % slides.length; // 0, 1, 2 로 순환
        slides[slideIndex].style.display = "block";
        timeout = setTimeout(showSlides, 3000); // 3000 밀리초 후에 showSlides 함수를 다시 호출하여 이미지를 자동으로 변경합니다.
    }

    function changeSlide(n) {
        clearTimeout(timeout); // 사용자가 수동으로 슬라이드를 변경할 때 자동 슬라이드 변경 타이머를 초기화합니다
        let slides = document.getElementsByClassName("slider")[0].getElementsByTagName("img");

        if (n == -1) {
            slideIndex = (slideIndex+slides.length-2)%(slides.length) ;
            showSlides();
            //timeout = setTimeout(showSlides, 3000); // 그리고 3초 후에 다시 자동으로 슬라이드를 변경하기 시작합니다.
        }else if (n == 1) {
            showSlides();
            //timeout = setTimeout(showSlides, 3000); // 그리고 3초 후에 다시 자동으로 슬라이드를 변경하기 시작합니다.
        }
    }
</script>
</body>
</html>
