<%@ page import="quiz.model.QuizDao" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Vector" %>
<%@ page import="quiz.model.QuizDto" %><%--
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
<%
    //전체 데이터 가져오기
    QuizDao dao = new QuizDao();
    Vector<QuizDto> list = dao.getAllDatas();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
%>
<body>
<div>
    <button type="button" class="btn btn-info" onclick="location.href='insertForm.jsp'">입력폼</button>
        <hr>
        <table>
            <caption><b>전체 목록</b></caption>
            <tr>
                <th width="50">번호</th>
                <th width="100">이름</th>
                <th width="80">나이</th>
                <th width="180">번호</th>
                <th width="100">운전면허</th>
                <th width="180">날짜</th>
                <th width="180">수정/삭제</th>
            </tr>
            <%
                for (int i = 0; i < list.size(); i++) {
                    QuizDto dto = list.get(i);
            %>

            <tr>
                <td><%=i+1%></td>
                <td><%=dto.getName()%></td>
                <td><%=dto.getAge()%></td>
                <td><%=dto.getPhone()%></td>
                <td><%=dto.getHasDriver().equals("true")?"있음O":"없음X"%></td>
                <td><%=sdf.format(dto.getDate())%></td>
                <td>
                    <button type="button" >수정</button>
                    <button type="button">삭제</button>
                </td>
            </tr>
            <%}%>
        </table>
    </button>
</div>

</body>
</html>
