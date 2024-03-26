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

    String[] hpParts = dto.getHp().split("-");



%>
<div style="margin: 100px 100px; width: 750px;">
    <form action="./updateAction.jsp" method="post" onsubmit="return check(this)">
        <table class="table table-bordered" >
            <caption align="top"><b>회원정보 수정</b></caption>
            <tr>
                <th width="100" class="table-success">아이디</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="text" name="id" id="id" maxlength="8" class="form-control"
                               required="required" style="width: 120px;" value="<%=dto.getId()%>">
                        <!-- 중복체크 버튼 제거 -->
                        <span class="idsuccess" style="color: blue; margin-left: 10px;"></span>
                    </div>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-success">비밀번호</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="password" name="pass" class="form-control"
                               required="required" style="width: 130px;" placeholder="비밀번호">
                        <input type="password" name="pass2" class="form-control"
                               required="required" style="width: 130px; margin-left: 5px;"placeholder="비밀번호 확인">
                    </div>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-success">이름</th>
                <td>
                    <input type="text" name="name" class="form-control" required="required" style="width: 120px;" value="<%=dto.getName()%>">
                </td>
            </tr>

            <tr>
                <th width="100" class="table-success">핸드폰</th>
                <td>
                    <input type="text" name="hp1"  required="required" style="width: 60px;" value="<%=hpParts[0]%>"> -
                    <input type="text" name="hp2"  required="required" style="width: 60px;" value="<%=hpParts[1]%>"> -
                    <input type="text" name="hp3"  required="required" style="width: 60px;" value="<%=hpParts[2]%>">
                </td>
            </tr>
            <tr >
                <th width="100" class="table-success" rowspan="3">주소</th>
                <td>
                    <input type="text" id="post_code" name="post_code" placeholder="우편번호" readonly>
                    <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                </td>
            </tr>
            <tr>
                <td>
                    <input type="text" id="roadAddress" name="roadAddress" placeholder="도로명주소" readonly>
                    <input type="text" id="jibunAddress" name="jibunAddress" placeholder="지번주소" readonly>
                    <span id="guide" style="color:#999;display:none"></span></td></tr>
            <tr>
                <td>
                    <input type="text" id="detailAddress" name="detailAddress" placeholder="상세주소">
                    <input type="text" id="extraAddress" name="extraAddress" placeholder="참고항목" readonly>
                    <%--                    <input type="text" name="addr" class="form-control" required="required" style="width: 330px;">--%>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-success">이메일</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="text" name="email1" class="form-control" required="required"
                               style="width: 80px;">
                        <b style="margin-left: 10px;">@</b>
                        <input type="text" name="email2" id="email2" class="form-control" required="required"
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
                    <button type="submit" class="btn btn-outline-info"
                            style="width: 100px;">저장하기</button>
                    <button type="reset" class="btn btn-outline-info"
                            style="width: 100px;">초기화</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
