<%@ page import="simpleguest.model.GuestDao" %>
<%@ page import="simpleguest.model.GuestDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-08
  Time: 오후 4:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    request.setCharacterEncoding("utf-8");

    String num = request.getParameter("num");
    String pass = request.getParameter("pass");
    String nickname = request.getParameter("nickname");
    String content = request.getParameter("content");
    String image = request.getParameter("image");

    GuestDao dao = new GuestDao();
    //비밀번호가 맞으면 수정후 목록ㅇ로 이동
    if (dao.isEqualPass(num, pass)) {

        GuestDto dto = new GuestDto();
        dto.setNum(num);
        dto.setNickname(nickname);
        dto.setContent(content);
        dto.setImage(image);

        dao.updateGuest(dto);
        response.sendRedirect("guestList.jsp");

    }else{%>
<script type="text/javascript">
    alert("비밀번호가 맞지 않습니다");
    history.back();
</script>


    <%}%>
