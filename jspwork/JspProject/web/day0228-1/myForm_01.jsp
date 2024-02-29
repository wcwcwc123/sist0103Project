<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-02-28
  Time: 오후 3:10
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
    <h2>데이터 여러개 전송하기</h2>
    <form action="formWhite_01.jsp" method="post">
        <table class="table table-borderd">
            <tr>
                <th width="100" class="table-info">이름</th>
                <td>
                    <input type="text" name="name" placeholder="이름" required="required" style="width: 120px">
                </td>
            </tr>

            <tr>
                <th width="100" class="table-info">비밀번호</th>
                <td>
                    <input type="password" name="pass" placeholder="비밀번호" required="required" style="width: 120px">
                </td>
            </tr>

            <tr>
                <th width="100" class="table-info">운전면허</th>
                <td>
                    <input type="checkbox" name="cblic">운전면허
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
