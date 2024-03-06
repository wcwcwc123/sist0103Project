<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-06
  Time: AM 9:15
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
<div style="margin: 30px 50px">
    <b>음식사진선택: </b>
    <select name="" id="selImage">
        <option value="1">샌드위치</option>
        <option value="2">닭꼬치</option>
        <option value="7">에그인헬</option>
        <option value="11">망고빙수</option>
        <option value="6">계란볶음밥</option>
    </select>
    <br><br>
    <input type="text" id="likeScore1">
    <input type="text" id="likeScore2">
    <input type="text" id="likeScore3">

    <button type="button" id="btn1">데이터전송</button>
    <br><br>
    <div id="result"></div>

    <script type="text/javascript">
        $("#btn1").click(function () {
            var foodphoto = $("#selImage").val();
            var foodname = $("#selImage option:selected").text();

            var s = "foodphoto="+foodphoto+"&foodname="+foodname;
            console.log(s);

            var s1 = $("#likeScore1").val();
            var s2 = $("#likeScore2").val();
            var s3 = $("#likeScore3").val();

            $.ajax({
                type: "get",
                url: "formDataRecieve.jsp",
                data:{
                    "s1":s1,
                    "s2":s2,
                    "s3":s3,
                    "foodphoto":foodphoto,
                    "foodname":foodname
                },
                dataType: "json",
                success:function (res){
                    console.log({res});
                    //res.foodname, res.foodphoto, res.total, res.avg
                    var s = "<h4>"+res.foodname+"</h4>"+
                        "<img src='"+res.foodphoto+"'</img>"+
                        "<h5>총점: "+res.total+"</h5>"+
                        "<h5>평균: "+res.avg+"</h5>";

                    $("#result").html(s);

                }
            })
        });
    </script>


</div>


</body>
</html>
