<%@ page import="data.dao.MemberDao" %>
<%@ page import="data.dto.MemberDto" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-21
  Time: 오후 12:15
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
    <script>
        $(function () {
            //이메일 선택 이벤트
            $("#selemail").change(function(){

                if($(this).val()=='-'){
                    $("#email2").val('');
                }else{
                    $("#email2").val($(this).val());
                }
            });

        });

        function check(f) {
            if (f.pass.value != f.pass2.value) {
                alert("비밀번호가 서로 다릅니다");
                //초기화
                f.pass.value = "";
                f.pass2.value = "";
                return false; //action호출하지 않는다
            }
        }
    </script>
</head>
<body>
<%
    String num = request.getParameter("num");
    MemberDao dao = new MemberDao();
    MemberDto dto = dao.getOneMember(num);

    System.out.println(dto.getId());

    String email = dto.getEmail();
    String[] emailParts = email.split("@");

%>
<div style="margin: 100px 100px; width: 500px;">
    <form action="./updateAction.jsp" method="post" onsubmit="return check(this)">
        <table class="table table-bordered" >
            <caption align="top"><b>회원정보 수정</b></caption>
            <tr>
                <th width="100" class="table-success">아이디</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="text" name="id" id="id" maxlength="8" class="form-control"
                               required="required" style="width: 120px;" value="<%=dto.getId()%>" >
                        <!-- 중복체크 버튼 제거 -->
                        <span class="idsuccess" style="color: blue; margin-left: 10px;"></span>
                    </div>
                </td>
            </tr>
            <!-- 나머지 필드들은 기존 값으로 채워진 상태로 표시, 예를 들어 -->
            <tr>
                <th width="100" class="table-success">비밀번호</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="password" name="pass" class="form-control"
                               required="required" style="width: 130px;" placeholder="비밀번호">
                        <input type="password" name="pass2" class="form-control"
                               required="required" style="width: 130px; margin-left: 5px;" placeholder="비밀번호 확인">
                    </div>
                </td>
            </tr>
            <!-- 여기에 추가 필드들이 이어집니다... -->
            <tr>
                <th width="100" class="table-success">이름</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="text" name="name" class="form-control" value="<%=dto.getName()%>"
                               required="required" style="width: 130px;" placeholder="이름">
                    </div>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-success">핸드폰</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="tel" name="hp" class="form-control" value="<%=dto.getHp()%>"
                               required="required" style="width: 180px;" placeholder="핸드폰">
                    </div>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-success">주소</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="text" name="addr" class="form-control" value="<%=dto.getHp()%>"
                               required="required" style="width: 330px;" placeholder="주소">
                    </div>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-success">이메일</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="text" name="email1" class="form-control" required="required" value="<%=emailParts[0]%>"
                               style="width: 80px;">
                        <b style="margin-left: 10px;">@</b>
                        <input type="text" name="email2" id="email2" class="form-control" required="required" value="<%=emailParts[1]%>"
                               style="width: 120px; margin-left: 10px;">
                        <select id="selemail" class="form-control" style="margin-left: 10px;">
                            <option value="-">직접입력</option>
                            <option value="naver.com">네이버</option>
                            <option value="nate.com">네이트</option>
                            <option value="gmail.com">구글</option>
                            <option value="daum.net">다음</option>

                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="hidden" name="num" value="<%=num%>">

                    <button type="submit" class="btn btn-outline-info"
                            style="width: 100px;">수정하기</button>
                    <button type="reset" class="btn btn-outline-info"
                            style="width: 100px;">초기화</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
