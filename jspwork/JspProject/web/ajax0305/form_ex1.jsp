<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-05
  Time: PM 3:31
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
<h3>폼태그에 데이타 입력타 입력후 jsp로 보내기</h3>
이름: <input type="text" id="name" size="10"><br>
핸드폰: <input type="text" id="hp" size="12"><br>
<button type="button" id="btn1">ajax로 서버에 보내기#1</button>
<button type="button" id="btn2">ajax로 서버에 보내기#2</button>
<hr>
<div id="show"></div>



<script>
    $("#btn1").click(function () {

        //입력한 값 얻기
        var name = $("#name").val();
        var hp = $("#hp").val();

        var data = "name="+name+"&hp="+hp; //방법1

        //ajax함수를 통해서 백엔드로 데이터를 보낸다
        $.ajax({
            type: "get",
            url: "read1_ex1.jsp",
            dataType: "html", //백엔드에서 아무것도 리턴안할경우 html
            //data:data,
            data:{"name":name, "hp": hp}, //방법2
            success: function (res) {
                console.log("res: " + res);
               $("#show").html("<h3 class='alert alert-info'>"+data+"</h3>")
            },
            statusCode:{
                404:function(){
                    alert("파일x");
                },
                500: function () {
                    alert("서버오류");
                }
            }
        })
    });
    $("#btn2").click(function () {
        var name = $("#name").val();
        var hp = $("#hp").val();

        console.log("hihi"+name);

        $.ajax({
            type: "get",
            url: "read2_ex1.jsp",
            dataType: "xml",
            data:{
                "name":name,
                "hp":hp
            },
            success:function(res) {

                var s ="<h2>"+$(res).find("name").text()+" 님 데이터를 DB에 추가했어요</h2>";
                $("#show").html(s);
            },
            statusCode:{
                404:function(){
                    alert("파일x");
                },
                500: function () {
                    alert("서버오류");
                }
            }
        })
    });
</script>

</body>
</html>
