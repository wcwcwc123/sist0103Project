<%@page import="java.text.SimpleDateFormat"%>
<%@page import="info.model.InfoDto"%>
<%@page import="java.util.Vector"%>
<%@page import="info.model.InfoDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Gowun+Dodum&family=IBM+Plex+Sans+KR&family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
</head>
<%
    // 전체 데이터 메서드 가져오기
    InfoDao dao=new InfoDao();
    Vector<InfoDto> list=dao.getAllDatas();
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일");

%>
<body>
<div style="margin: 50px 100px;">

    <button type="button" class="btn btn-info" onclick="location.href='addForm.jsp'">입력폼</button>
    <hr>
    <table class="table table-bordered" style="width:800px;">
        <caption align="top"><b>info 전체 목록</b></caption>
        <tr class=table-success>
            <th width="80">번호</th>
            <th width="120">이름</th>
            <th width="350">주소</th>
            <th width="180">날짜</th>
            <th width="200">수정/삭제</th>
        </tr>

        <%
            for(int i=0; i<list.size(); i++){
                InfoDto dto=list.get(i);
        %>

        <tr>
            <td align="center"><%=i+1 %></td>
            <td><%=dto.getName() %></td>
            <td><%=dto.getAddr() %></td>
            <td><%=sdf.format(dto.getSdate()) %></td>
            <td>
                <button type="button" class="btn btn-info btn-sm" onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
                <button type="button" class="btn btn-danger btn-sm" onclick="location.href='infoDelete.jsp?num=<%=dto.getNum()%>'">삭제</button>
            </td>
        </tr>
        <%}
        %>

    </table>
</div>
</body>
</html>