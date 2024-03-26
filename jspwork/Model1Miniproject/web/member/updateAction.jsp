<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="data.dao.MemberDao" %>
<%@ page import="data.dto.MemberDto" %>
<%@ page import="java.io.IOException" %>
<%
    // 요청 파라미터 받기
    String num = request.getParameter("num");
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
    // 추가적으로 필요한 파라미터들
    String name = request.getParameter("name");
    String hp = request.getParameter("hp");
    String addr = request.getParameter("addr");
    String email = request.getParameter("email1") + "@" + request.getParameter("email2");

    System.out.println("name:" + name);

    // DTO 생성 및 파라미터 셋팅
    MemberDto dto = new MemberDto();
    dto.setId(id);
    dto.setPass(pass);
    dto.setName(name);
    dto.setHp(hp);
    dto.setAddr(addr);
    dto.setEmail(email);
    dto.setNum(num);

    // DAO를 통한 데이터베이스 업데이트
    MemberDao dao = new MemberDao();
    dao.updateMember(dto);

    response.sendRedirect("../index.jsp?main=member/memberList.jsp"); // 성공 시 리디렉트할 페이지

/*    // 업데이트 결과에 따른 처리
    if(result > 0) {
        // 업데이트 성공
        response.sendRedirect("updateSuccess.jsp"); // 성공 시 리디렉트할 페이지
    } else {
        // 업데이트 실패
        response.sendRedirect("updateFail.jsp"); // 실패 시 리디렉트할 페이지
    }*/
%>