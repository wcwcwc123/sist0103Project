<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-21
  Time: 오후 5:29
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
    <!-- Swiper의 CSS -->
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css"/>

    <!-- Swiper의 JS -->
    <script src="https://unpkg.com/swiper/swiper-bundle.min.js">
    </script>
    <script>
        // 문서가 준비된 후 Swiper 인스턴스를 생성
        document.addEventListener('DOMContentLoaded', function () {
            var mySwiper = new Swiper('.swiper', {
                // 옵션 설정
                loop: true, // 루프 모드 활성화
                navigation: {
                    nextEl: '.swiper-button-next', // 다음 버튼 요소
                    prevEl: '.swiper-button-prev', // 이전 버튼 요소
                },
                // 자동 전환 설정
                autoplay: {
                    delay: 3000, // 3초 후 자동 전환
                    disableOnInteraction: false, // 사용자 인터랙션 후에도 자동 전환 계속
                },
                // 더 많은 옵션들...
            });
        });

    </script>

</head>
<body>
<!-- Swiper -->
<div class="swiper">
    <!-- Swiper의 슬라이드들 -->
    <div class="swiper-wrapper">
        <div class="swiper-slide">슬라이드 1</div>
        <div class="swiper-slide">슬라이드 2</div>
        <div class="swiper-slide">슬라이드 3</div>
        <!-- 더 많은 슬라이드들... -->
    </div>
    <!-- 필요한 경우 네비게이션 버튼들 -->
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
</div>

</body>
</html>
