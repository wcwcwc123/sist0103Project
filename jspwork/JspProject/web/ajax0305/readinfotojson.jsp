
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
          rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>

    <title>Title</title>
    <style>
        #show {
            font-family: 'Dongle';
            font-size: 1.5em;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <h2>info db...json으로 파싱한것 읽어오기</h2>
    <button type="button" class="btn btn-info" id="btninfo">
        info 읽기
    </button>
    <div id="show"></div>
    <script type="text/javascript">

        $("#btninfo").click(function (){
            $.ajax({
                type: "get",
                url: "infotojson.jsp",
                dataType: "json",
                success: function (res) {
                    var s = "";

                    $.each(res, function (i, item) {

                        var innerstring = '<div class ="alert alert-success" style="width:300px;">' +
                            'index: ' + (i+1) + '<br>' +
                            'num: ' + item.num + '<br>' +
                            '이름: ' + item.name + '<br>' +
                            '핸드폰: ' + item.hp + '<br>' +
                            '나이: ' + item.age + '<br>' +
                            '<img src="' + item.photo + '" width="100">' +
                            '</div>';
                        s+=innerstring;
                        console.log(s);
                    });
                    $("#show").html(s);
                }
            })

        })

    </script>


</body>
</html>
