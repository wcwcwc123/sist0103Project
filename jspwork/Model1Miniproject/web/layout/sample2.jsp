<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-20
  Time: 오후 4:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <title>Title</title>
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
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

    </style>

</head>
<%
    //프로젝트 경로
    String root=request.getContextPath();
%>
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
<!-- Swiper -->
<div class="swiper mySwiper">
    <div class="swiper-wrapper">
        <div class="swiper-slide"><img src="../image/banner-01.png" alt="광고 1" style="width: 100%;"></div>
        <div class="swiper-slide"><img src="../image/banner-02.png" alt="광고 2" style="width: 100%;"></div>
        <div class="swiper-slide"><img src="../image/banner-03.png" alt="광고 3" style="width: 100%;"></div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
    <!-- Add Navigation -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>

<h3>주요 제품 둘러보기</h3>
<br>
<img alt="" src="<%=root %>/image/1.png">
<img alt="" src="<%=root %>/image/6.png"><br>
<img alt="" src="<%=root %>/image/7.png">
<img alt="" src="<%=root %>/image/10.png">

<script>
    var mySwiper = new Swiper('.mySwiper', {
        loop:true,
        spaceBetween: 30,
        centeredSlides: true,
        autoplay: {
            delay: 2500,
            disableOnInteraction: false,
        },
        pagination: {
            el: '.swiper-pagination',
            clickable: true,
        },
        navigation: {
            nextEl: '.swiper-button-next',
            prevEl: '.swiper-button-prev',
        },
        effect: 'slide', // 'slide', 'fade', 'cube', 'coverflow' 또는 'flip' 중 선택
    });
</script>
</body>
</html>
