<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-28
  Time: 오후 4:05
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
<form action="quizWrite.jsp" method="post">
    <table class="table table-borderd">
        <tr>
            <th width="100" class="table-info">사원명</th>
            <td>
                <input type="text" name="name" placeholder="사원명" required="required" style="width: 120px">
            </td>
        </tr>

        <tr>
            <th width="100" class="table-info">입사일자</th>
            <td>
                <input type="date" name="hiredate" required="required">
            </td>
        </tr>

        <tr>
            <th width="100" class="table-info">오늘 선택 점심 메뉴</th>
            <td>
                <input type="radio" name="menu" value="../image/Food/1.jpg">
                <label for="a">돈까스</label>
                <input type="radio" name="menu" value="../image/Food/2.jpg">
                <label for="b">라면</label>
                <input type="radio" name="menu" value="../image/Food/3.jpg">
                <label for="c">스테이크</label>
            </td>
        </tr>

        <tr>
            <th width="170" class="table-info">건의하는 메뉴</th>
            <td>
                <select name="hopemenu" class="form-control" multiple="multiple">
                    <option value="쌀국수">쌀국수</option>
                    <option value="마라탕">마라탕</option>
                    <option value="비빔밥">비빔밥</option>
                    <option value="햄버거">햄버거</option>
                    <option value="냉면">냉면</option>
                </select>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" class="btn btn-success" value="전송">
                <input type="reset" class="btn btn-warning" value="초기화">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
