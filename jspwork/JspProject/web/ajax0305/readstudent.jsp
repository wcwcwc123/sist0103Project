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
<h2>student json 연습</h2>
<button type="button" id="btnstudent" class="btn btn-info" >자바순 </button>
<button type="button" id="btnnum" class="btn btn-info" >학번순 </button>
<div id="show"></div>

<script>
    $.ajax({
        type: "get",
        url: "studenttojson.jsp",
        dataType: "json",
        success: function(res){
            var s = "";
            console.log(res);
            $.each(res, function (i, item) {
                var innerString = '<div class ="alert alert-success" style="width:300px;">' +
                    '순위: '+(i+1) +'등<br>'+
                    '이름: '+item.name+'<br>'+
                    '<img src="'+item.photo+'" width="100">'+'<br>'+
                    '자바: '+item.java+'<br>'+
                    '스프링: '+item.spring+
                    '</div>';
                s+=innerString;
            });
            console.log(s);
            $("#show").html(s);
        }
    })

    // function sendData(value){
    //
    //     var xhr = new XMLHttpRequest();
    //
    //     xhr.open("POST", "studenttojson.jsp", true);
    //     xhr.setRequestHeader("Content-Type","aplication/x-www-form-urlencoded");
    //     xhr.onreadystatechange =function (){
    //         if (xhr.readyState === 4 && xhr.status === 200) {
    //             console.log(xhr.responseText);
    //         }
    //     };
    //     xhr.send("value="+encodeURIComponent(value));
    // };


    $("#btnstudent").click(function(){

        $.ajax({
            type: "get",
            url: "studenttojson.jsp?value=java",
            dataType: "json",
            success: function(res){
                console.log(res);
                var s = "";
                $.each(res, function (i, item) {
                    var innerString = '<div class ="alert alert-success" style="width:300px;">' +
                        '순위: '+(i+1) +'등<br>'+
                        '학번: '+item.num+ '<br>'+
                        '이름: '+item.name+'<br>'+
                        '<img src="'+item.photo+'" width="100">'+'<br>'+
                        '자바: '+item.java+'<br>'+
                        '스프링: '+item.spring+
                        '</div>';
                    s+=innerString;
                });
                $("#show").html(s);
            }
        })
    });
    $("#btnnum").click(function(){
        $.ajax({
            type: "get",
            url: "studenttojson.jsp?value=num",
            dataType: "json",
            success: function(res){
                var s = "";
                $.each(res, function (i, item) {
                    var innerString = '<div class ="alert alert-success" style="width:300px;">' +
                        '순위: '+(i+1) +'등<br>'+
                        '학번: '+item.num+ '<br>'+
                        '이름: '+item.name+'<br>'+
                        '<img src="'+item.photo+'" width="100">'+'<br>'+
                        '자바: '+item.java+'<br>'+
                        '스프링: '+item.spring+
                        '</div>';
                    s+=innerString;
                });
                $("#show").html(s);
            }
        })
    });

</script>

</body>
</html>
