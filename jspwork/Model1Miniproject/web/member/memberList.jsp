<%@ page import="data.dao.MemberDao" %>
<%@ page import="data.dto.MemberDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-20
  Time: 오후 12:02
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
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        table, th, td {
            border: 1px solid black;
        }
        th, td {
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .button {
            display: inline-block;
            padding: 5px 10px;
            font-size: 12px;
            cursor: pointer;
            text-align: center;
            text-decoration: none;
            outline: none;
            color: #fff;
            background-color: #4CAF50;
            border: none;
            border-radius: 5px;
            box-shadow: 0 3px #999;
        }

        .button:hover {background-color: #3e8e41}

        .button:active {
            background-color: #3e8e41;
            box-shadow: 0 2px #666;
            transform: translateY(4px);
        }

        .delete-button {
            background-color: #f44336;
        }

        .delete-button:hover {
            background-color: #d32f2f;
        }
        #top-title {
            display: flex;
            justify-content: space-between;
            align-items: center; /* 세로 축에서의 정렬을 중앙으로 설정 */
            margin-bottom: 20px;
        }

        h2 {
            margin: 0; /* 필요에 따라 조정 */
        }

        #deleteSelected {
            background-color: #f44336;
            margin-right: 50px;
            margin-bottom: 10px;
            margin-top: 10px;
            transform: scale(1.2);
            padding: 10px;
        }
        .delete-checkbox,#selectAll{
            transform: scale(1.45);
        }
        th,td{
            text-align: center;
        }

    </style>
    <script>
        $(function () {

            $(".delete-button").click(function () {

                if (confirm("정말 삭제하시겠습니까?")) {

                    var $thisButton = $(this);

                    const num = $thisButton.data("num");

                    $.ajax({
                        type: "post",
                        url:"./member/memberDelete.jsp",
                        dataType: "json",
                        data:{num},
                        success: function (res) {
                            if (res.success == "true") {
                                console.log(res);
                                $thisButton.closest("tr").remove();
                            }else{
                                console.error("delete failed");
                            }


                        },
                    })

                } else {
                    return;
                }


            });

            $("#deleteSelected").click(function () {
                var selectedNums = $(".delete-checkbox:checked").map(function () {
                    return $(this).data("num");
                }).get();

                if (selectedNums.length === 0) {
                    alert("삭제할 항목을 선택해주세요.");
                    return;
                }

                $.ajax({
                    type: "post",
                    url: "./member/memberBatchDelete.jsp", // 서버의 일괄 삭제 처리 페이지
                    dataType: "json",
                    traditional: true, // 배열을 query string으로 전달하기 위해 필요
                    data: { nums: selectedNums },
                    success: function (res) {
                        if (res.success == "true") {
                            $(".delete-checkbox:checked").closest("tr").remove();
                        } else {
                            console.error("Batch delete failed");
                        }
                    },
                })
            });

            $("#selectAll").click(function () {
                $(".delete-checkbox").prop('checked', this.checked);
            });



        });
    </script>

</head>
<body>
<%
    MemberDao dao = new MemberDao();
    List<MemberDto> list = dao.getAllMembers();
    SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");

%>

<div id="top-title">
    <h2>회원 정보 관리</h2>
    <button id="deleteSelected" class="button delete-batch-button">선택 삭제</button>
</div>


<table>
    <tr>
        <th><input type="checkbox" id="selectAll"/></th>
        <th>번호</th>
        <th>이름</th>
        <th>아이디</th>
        <th>핸드폰</th>
        <th>주소</th>
        <th>이메일</th>
        <th>가입일</th>
        <th>수정</th>
        <th>삭제</th>
    </tr>
    <%
        for (int i = 0; i < list.size(); i++) {
            %>
    <tr>
        <td><input type="checkbox" class="delete-checkbox" data-num="<%=list.get(i).getNum()%>"/></td>
        <td><%=list.get(i).getNum()%></td>
        <td><%=list.get(i).getName()%></td>
        <td><%=list.get(i).getId()%></td>
        <td><%=list.get(i).getHp()%></td>
        <td><%=list.get(i).getAddr()%></td>
        <td><%=list.get(i).getEmail()%></td>
        <td><%=sdf.format(list.get(i).getGaipday())%></td>
        <td><button class="button" onclick="window.location.href='member/updateForm.jsp?num=<%=list.get(i).getNum()%>'">수정</button></td>
        <td><button class="button delete-button" data-num="<%=list.get(i).getNum()%>">삭제</button></td>
    </tr>

        <%}%>


    <!-- 여기에 더 많은 회원 정보 행을 추가할 수 있습니다 -->
</table>

</body>
</html>
