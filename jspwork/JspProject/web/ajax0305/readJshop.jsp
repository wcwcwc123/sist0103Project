<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
    <style type="text/css">
        #out{
            margin-top: 30px;
            font-family: 'Gaegu';
            font-size: 1.5em;
        }

        .box{
            width: 40px;
            height: 40px;
            border-radius: 100px;

        }
    </style>

    <script type="text/javascript">
        $(function(){

            $("#btnshop").click(function(){

                $.ajax({

                    type:"get",
                    url:"jshoptojson.jsp",
                    dataType:"json",
                    success:function(data){

                        var s="<table class='table table-bordered' style='width:700px;'>";
                        s+="<caption align='top'><b>Json Jshop읽어오기</b></caption>";
                        s+="<tr class='table-success'>";
                        s+="<th>번호</th><th>상품명</th><th>색상</th><th>가격</th><th>상품이미지</th>";
                        s+="</tr>";

                        $.each(data,function(i,elt){

                            s+="<tr>";
                            s+="<td>"+elt.num+"</td>";
                            s+="<td>"+elt.sangpum+"</td>";
                            s+="<td>"+elt.color+"<br>"+"<div class='box' style='background-color:"+elt.color+";'></div></td>";
                            s+="<td>"+elt.price+"</td>";
                            s+="<td><img src='"+elt.imagename+"' width='50'></td>";
                            s+="<tr>";
                        });

                        s+="</table>";
                        $("#out").html(s);
                    }
                });
            });
        });

    </script>
</head>
<body>
<button type="button" class="btn btn-warning" id="btnshop">JShop DB데이타 읽어오기</button>
<div id="out"></div>
</body>
</html>