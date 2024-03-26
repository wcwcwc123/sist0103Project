<%@page import="data.dto.GuestDto"%>
<%@page import="data.dao.GuestDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
    <style type="text/css">
        .bi-camera{
            color: purple;
        }
    </style>
    <script type="text/javascript">
        $(function(){
            $("i.camera").click(function(){
                $("#photo").trigger("click");
            })
        });


        function readURL(input) {
            if (input.files && input.files[0]) {
                var reader = new FileReader();
                reader.onload = function (e) {
                    $("#showimg").attr('src', e.target.result);
                }
                reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</head>
<%
    //num,currentPage
    String num=request.getParameter("num");
    String currentPage=request.getParameter("currentPage");

    GuestDao dao=new GuestDao();
    GuestDto dto=dao.getData(num);
%>
<body>

<!-- 이미지미리보기 -->
<img id="showimg" style="position: absolute; left: 800px; top: 100px; max-width: 200px;"
     src="<%=(dto.getPhotoname()==null?"":"save/"+dto.getPhotoname())%>">

<div style="margin: 50px 100px; width: 600px;">
    <form action="memberguest/updateaction.jsp" method="post" enctype="multipart/form-data">

        <!--num hidden: 페이징처리시는 currentPage도 hidden처리  -->
        <input type="hidden" name="num" value="<%=num%>">
        <input type="hidden" name="currentPage" value="<%=currentPage%>">
        <table class="table table-bordered">
            <caption align="top">
                <b>방명록 수정</b>&nbsp;&nbsp;
                <i class="bi bi-camera fs-2 camera"></i>
                <input type="file" name="photo" id="photo" style="visibility: hidden;"
                       onchange="readURL(this)">
            </caption>

            <tr>
                <td>
            <textarea style="width: 500px; height: 100px;"
                      name="content" class="from-control"
                      required="required"><%=dto.getContent() %></textarea>
                </td>
                <td>
                    <button type="submit" class="btn btn-warning"
                            style="width: 100px; height: 100px;">수정</button>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>