<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-29
  Time: 오후 4:11
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
<div>
    <form action="insertAction.jsp" method="post">
        <table class="table table-bordered">
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" placeholder="이름">
                </td>
            </tr>
            <tr>
                <th>나이</th>
                <td>
                    <input type="text" name="age" placeholder="나이">
                </td>
            </tr>
            <tr>
                <th>핸드폰</th>
                <td>
                    <input type="text" name="phone" placeholder="핸드폰">
                </td>
            </tr>
            <tr>
                <th>운전면허 유무</th>
                <td>
                    <input type="checkbox" name="driver" >
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" value="입력">
                    <input type="button" value="목록" onclick="location.href='./list.jsp' ">
                </td>

            </tr>



        </table>
    </form>
</div>

</body>
</html>
