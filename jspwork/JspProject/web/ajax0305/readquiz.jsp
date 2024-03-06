<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-05
  Time: PM 3:04
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
    <style type="text/css">
        ul li {
            list-style: none;
            width: 150px;
            height: 50px;
            text-align: center;
            line-height: 50px;
            border: 1px solid tomato;
            margin: 5px;
            float: left;
            cursor: pointer;
        }
        .bg1 {
            background-color: tomato;
            color: aliceblue;
        }
    </style>
    <script>
        $(function (){
            $("li").eq(0).click(function () {
                var s = "<img src='../image/쇼핑몰사진/1.jpg'>";
                $("#show").html(s);
            });
            $("li").eq(1).click(function () {
                $.ajax({
                    type: "get",
                    url:"../ajax0304/foodtoxml.jsp",
                    dataType: "json",
                    success:function(data){
                        $("#show").html(data);
                    }
                })

            });
            $("li").eq(2).click(function () {
                var s = "<img src='../image/쇼핑몰사진/1.jpg'>";
                $("#show").html(s);
            });



        })
    </script>
</head>
<body>
    <ul>
        <li>Home</li>
        <li>Food</li>
        <li>Info</li>
    </ul>
    <div style="clear: both;"></div>

    <div id="show" style="margin-top: 50px;"></div>
</body>
</html>
