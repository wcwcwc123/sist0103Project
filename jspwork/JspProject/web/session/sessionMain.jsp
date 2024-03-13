<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오전 9:35
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
    session.setAttribute("msg", "happy");
    session.setMaxInactiveInterval(10);

%>
<h2>10초안에 눌러주세요!!!</h2>
<form action="sessionAction.jsp" method="post">
    <h2>받고싶은 생일 선물은?</h2>
    <input type="radio" value="아이폰15" name="gift">아이폰15&nbsp;
    <input type="radio" value="갤럭시 폴드" name="gift">갤럭시 폴드&nbsp;
    <input type="radio" value="백화점" name="gift">백화점&nbsp;
    <input type="radio" value="현금100" name="gift" checked>현금100&nbsp;

    <input type="submit" value="선물선택">

</form>
<div id="countdown" style="font-size: 30px; color: red">10</div>
<script>
    // 초기 숫자 설정
    let count = 10;

    // 카운트 다운 함수
    function countdown() {
        // 숫자가 0보다 작거나 같으면 종료
        if (count <= 0) {
            clearInterval(timer);
            document.getElementById("countdown").textContent = "0";
            return;
        }

        // 숫자를 표시하고 1초씩 감소
        document.getElementById("countdown").textContent = count;
        count--;
    }

    // 1초마다 countdown 함수 호출
    let timer = setInterval(countdown, 1000);
</script>

</body>
</html>
