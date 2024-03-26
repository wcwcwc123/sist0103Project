<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
    <script type="text/javascript">
        $(function(){

            //아이디 중복체크
            $("#btnIdCheck").click(function(){

                //id읽기
                var id=$("#id").val();
                //alert(id);
                $.ajax({
                    type:"get",
                    url:"member/idCheck.jsp",
                    dataType:"json",
                    data:{"id":id},
                    success:function(res){

                        //alert(res.count);
                        if(res.count==1){
                            //alert("이미 가입된 아이디입니다\n다시입력해 주세요");
                            $("span.idsuccess").text("not ok!!");
                            $("#id").val("");
                        }else{
                            //alert("가입이 가능한 아이디입니다");
                            $("span.idsuccess").text("ok!!");
                        }
                    }
                })
            });


            //이메일 선택 이벤트
            $("#selemail").change(function(){

                if($(this).val()=='-'){
                    $("#email2").val('');
                }else{
                    $("#email2").val($(this).val());
                }
            });

        })


        function check(f)
        {
            if(f.pass.value!=f.pass2.value){
                alert("비밀번호가 서로 다릅니다");
                //초기화
                f.pass.value="";
                f.pass2.value="";
                return false; //action호출하지 않는다
            }
        }
    </script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script>
        //본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
        function sample4_execDaumPostcode() {
            new daum.Postcode({
                oncomplete: function(data) {
                    // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                    // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                    // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                    var roadAddr = data.roadAddress; // 도로명 주소 변수
                    var extraRoadAddr = ''; // 참고 항목 변수

                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                        extraRoadAddr += data.bname;
                    }
                    // 건물명이 있고, 공동주택일 경우 추가한다.
                    if(data.buildingName !== '' && data.apartment === 'Y'){
                        extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                    if(extraRoadAddr !== ''){
                        extraRoadAddr = ' (' + extraRoadAddr + ')';
                    }

                    // 우편번호와 주소 정보를 해당 필드에 넣는다.
                    document.getElementById('post_code').value = data.zonecode;
                    document.getElementById("roadAddress").value = roadAddr;
                    document.getElementById("jibunAddress").value = data.jibunAddress;

                    // 참고항목 문자열이 있을 경우 해당 필드에 넣는다.
                    if(roadAddr !== ''){
                        document.getElementById("extraAddress").value = extraRoadAddr;
                    } else {
                        document.getElementById("extraAddress").value = '';
                    }

                    var guideTextBox = document.getElementById("guide");
                    // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                    if(data.autoRoadAddress) {
                        var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                        guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                        guideTextBox.style.display = 'block';

                    } else if(data.autoJibunAddress) {
                        var expJibunAddr = data.autoJibunAddress;
                        guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                        guideTextBox.style.display = 'block';
                    } else {
                        guideTextBox.innerHTML = '';
                        guideTextBox.style.display = 'none';
                    }
                }
            }).open();
        }
    </script>
</head>
<body>
<div style="margin: 100px 100px; width: 750px;">
    <form action="member/addAction.jsp" method="post" onsubmit="return check(this)">
        <table class="table table-bordered" >
            <caption align="top"><b>회원가입</b></caption>
            <tr>
                <th width="100" class="table-success">아이디</th>
                <td>
                    <div class="d-inline-flex">
                        <input type="text" name="id" id="id" maxlength="8" class="form-control"
                               required="required" style="width: 120px;">
                        <button type="button" class="btn btn-danger" id="btnIdCheck"
                                style="margin-left: 10px;">중복체크</button>
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
                    <input type="text" name="name" class="form-control" required="required" style="width: 120px;">
                </td>
            </tr>

            <tr>
                <th width="100" class="table-success">핸드폰</th>
                <td>
                    <input type="text" name="hp1"  required="required" style="width: 60px;"> -
                    <input type="text" name="hp2"  required="required" style="width: 60px;"> -
                    <input type="text" name="hp3"  required="required" style="width: 60px;">
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