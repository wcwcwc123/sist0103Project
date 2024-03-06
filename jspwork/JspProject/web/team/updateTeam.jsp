<%@ page import="team.model.TeamDao" %>
<%@ page import="team.model.TeamDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-06
  Time: PM 12:11
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
    String updateNum = request.getParameter("num");
    TeamDao dao = new TeamDao();
    TeamDto dto = dao.getOndeData(updateNum);



%>
<div style="margin: 30px 50px">
    <form action="updateAction.jsp" method="post">
        <table class="table table-bordered" style="width: 300px;">
            <caption>
                <b>팀회원 정보 수정</b>
            </caption>
            <tr>
                <th class="table-primary">이름</th>
                <td>
                    <input type="text" name="name" class="form-control" required="required" value="<%=dto.getName()%>">
                </td>
            </tr>
            <tr>
                <th class="table-primary">운전면허</th>
                <td>
                    <input type="checkbox" name="driver" <%=dto.getDriver().equals("true")?"checked":""%>>
                </td>
            </tr>
            <tr>
                <th class="table-primary">주소</th>
                <td>
                    <input type="text" name="addr" class="form-control" required="required" value="<%=dto.getAddr()%>">
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="num" value="<%=updateNum%>">
                    <button type="submit" class="btn btn-primary">팀회원정보저장</button>
                </td>

            </tr>
        </table>
    </form>
</div>

</body>
</html>
