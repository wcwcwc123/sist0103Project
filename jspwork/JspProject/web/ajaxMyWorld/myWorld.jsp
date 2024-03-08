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
        div.hello{
            position: absolute;
            border: 1px solid gray;
            font-family: 'Nanum Pen Script';
            font-size: 1.5em;
        }

        div.updateform{
            left: 100px;
            top: 150px;
            width: 500px;
            height: 600px;
            padding: 20px 20px;
            position: relative;
            font-family: 'Nanum Pen Script';
            font-size: 1.5em;
        }

        div.button{
            left: 150px;
            top: 30px;
            width: 400px;
            height: 100px;
            line-height: 100px;
            text-align: center;

        }

        div.addform,div.updateform{
            left: 100px;
            top: 150px;
            width: 500px;
            height: 600px;
            padding: 20px 20px;
        }

        img.avata{
            cursor: pointer;
        }


        img.select{
            border: 2px solid red;
        }
        div.list {
            left: 800px;
            top: 100px;
            width: 600px;
            padding: 20px 20px;
        }
        i.edit,i.del{
            float: right;;
        }

    </style>

    <script type="text/javascript">
        $(function(){

            list();

            //처음에 추가폼 없는상태로
            $("div.addform").hide();
            $("div.updateform").hide();

            //버튼누르면 추가폼 나오고 사라지게
            $("#btnadd").click(function(){
                $("div.updateform").hide();
                $("div.addform").slideToggle();
            });

            //아바타 이미지에 기본하나 select클래스 추가
            $("img.avata").eq(2).addClass("select");

            //2번아바타의 src값을 얻어서 input태그에 추가하기
            $("#avata").val($("img.avata").eq(2).attr("src"));

            $("img.avata").click(function () {

                $(this).siblings().removeClass("select");
                $(this).addClass("select");

                $("#avata").attr("value",$(this).attr("src"));
                console.log($(this).attr("src"));
            });

            $("img.up_avata").click(function () {

                $(this).siblings().removeClass("select");
                $(this).addClass("select");

                $("#up_avata").attr("value",$(this).attr("src"));
            });

            $("#dbSave").click(function () {
                $.ajax({
                    type: "get",
                    url: "worldInsert.jsp",
                    dataType: "html",
                    data:{
                        "writer":$("#writer").val(),
                        "content":$("#content").val(),
                        "avata":$("#avata").val(),
                    },
                    success: function (res){
                        console.log(res);
                        //추가 성공시 목록 다시 출력
                        list();
                        //alert("성공!!");
                        //입력값 초기화
                        $("#writer").val("");
                        $("#content").val("");
                        //아바타초기화
                        $("img.avata").removeClass("select");
                        $("img.avata").eq(2).addClass("select");
                        $("#avata").val($("img.avata").eq(2).attr("src"));
                        list();

                    }

                })
            });

            //삭제버튼 시작
            $(document).on("click", "i.del", function () {

                if(!confirm("삭제하시겠습니까??")){
                    return;
                }

                var num = $(this).attr("num");

                $.ajax({
                    type: "get",
                    url: "worldDelete.jsp",
                    dataType: "json",
                    data:{
                        "num": num
                    },
                    success: function (res) {
                        console.log({res});
                        $("div.addform").hide();
                        $("div.updateform").hide();
                        list();

                    },
                    error: function(xhr, status, error) {
                        // 오류가 발생했을 때 실행되는 코드
                        console.error("AJAX 오류: " + status + " - " + error);
                    }

                })
            }); //삭제 버튼 끝
            //수정 버튼 시작
            $(document).on("click", "i.edit", function () {
                var num = $(this).attr("num");
                console.log({num});
                $("div.addform").show();
                $("div.updateform").hide();

                $.ajax({
                    type: "get",
                    url: "worldUpdate.jsp",
                    dataType: "json",
                    data:{
                        "num":num
                    },
                    success: function (res) {
                        var number = res.avata.match(/\d+/)[0][1];

                        $("#up_writer").val(res.writer);
                        $("#up_content").val(res.content);
                        $("img.up_avata").siblings().removeClass("select");
                        $("img.up_avata").eq(number-1).addClass("select");
                        $("#up_avata").val(res.avata);
                        $("#num_for_update").val(res.num);
                        list();

                        //추가폼이 있으면 숨기고 수정폼을 나타낸다
                        $("div.addform").hide();
                        $("div.updateform").show();

                    },
                    error: function(xhr, status, error) {
                        // 오류가 발생했을 때 실행되는 코드
                        console.error("AJAX 오류: " + status + " - " + error);
                    }

                });
            }); //수정 끝
            //수정완료 시작
            $(document).on("click", "#up_dbSave", function () {

                $.ajax({
                    type: "get",
                    url: "worldUpdateAction.jsp",
                    dataType: "json",
                    data:{
                        "writer":$("#up_writer").val(),
                        "content":$("#up_content").val(),
                        "avata":$("#up_avata").val(),
                        "num": $("#num_for_update").val()
                    },
                    success: function (res){
                        console.log({res});
                        $("#up_writer").val("");
                        $("#up_content").val("");
                        $("img.up_avata").removeClass("select");
                        $("#up_avata").val("");
                        $("#num_for_update").val("");
                        $("#updateform").hide();

                        $("#updateform").hide();
                        list();

                    }

                })
            });


        })
        //사용자 함수 리스트
        function list() {
            $.ajax({
                type: "get",
                url: "worldList.jsp",
                dataType: "json",
                data:{

                },
                success: function (res) {
                    var s="";

                    $.each(res, function (i, item) {
                        const imgUrl = item.avata;
                        const content = item.content;
                        const num = item.num;
                        const writeday = item.writeday;
                        const writer = item.writer;

                        var newDiv = document.createElement("div");
                        var newImg = document.createElement("img");
                        newImg.setAttribute("src", imgUrl);
                        var newWriter = document.createElement("p");
                        newWriter.innerText = writer;

                        var newContent = document.createElement("p");
                        newContent.innerText = content;

                        var newWriteday = document.createElement("p");
                        newWriteday.innerText = writeday;

                        newDiv.appendChild(newWriter);
                        newDiv.appendChild(newImg);
                        newDiv.appendChild(newWriteday);
                        newDiv.appendChild(newContent);

                        var divlist = document.getElementsByClassName("list");

                        var helloDiv = document.querySelector(".list");
                        // divlist[0].appendChild(newDiv);


                        // divlist.appendChild(newDiv);
                        s+="<table class='table table-bordered'>";
                        s+="<tr><td>";
                        s+="<span class='writer'>작성자: "+writer+"&nbsp;&nbsp;</span>";
                        s+="<span class='day'>"+writeday+"</span>";
                        s+="<br>";
                        s+="<pre class='cont'>"+content;
                        s+="<img src='"+imgUrl+"' align='right' width='80'>";
                        s+="</pre>";
                        s+="</td></tr>";
                        s+="<i class='bi bi-pencil-square edit' num="+num+"></i>";
                        s+="<i class='bi bi-trash del' num="+num+"></i>";
                        s+="</table><br>";


                        // var s = "<img src='"+imgUrl+"'>"+
                        //     "<p>"+content+"</p>"+
                        //     "<p>"+num+"</p>"+
                        //     "<p>"+writeday+"</p>"+
                        //     "<p>"+writer+"</p>";
                        //
                    });
                    $("div.list").html(s);
                },
            })

        }
    </script>
</head>
<body>
<div class="hello button">
    <button type="button" class="btn btn-danger"
            id="btnadd" style="width: 120px;">방명록추가</button>
</div>
<div class="hello addform">
    <form id="addfrm">
        <table class="table table-bordered">
            <caption align="top"><b>방명록추가</b></caption>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" class="form-control input-sm"
                           name="writer" id="writer" style="width: 120px;">
                </td>

            </tr>
            <tr>
                <th>남기는말</th>
                <td>
                 <textarea style="width: 300px; height: 100px;"
                           class="form-control" name="content" id="content"></textarea>
                </td>
            </tr>
            <tr>
                <th>아바타</th>
                <td>
                    <input type="hidden" name="avata" id="avata">
                    <script type="text/javascript">
                        var s="";
                        for(var i=1;i<=10;i++){
                            s+="<img src='../image/avata/0"+i+".png' width='50' class='avata'>";

                            if(i==5)
                                s+="<br>";
                        }

                        document.write(s);
                    </script>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="button" class="btn btn-info"
                            id="dbSave">DB저장하기</button>
                </td>
            </tr>
        </table>
    </form>
</div>
<%--<div class="hello updateform">
    <form id="updateform">
        <table class="table table-bordered">
            <caption align="top"><b>update</b></caption>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" class="form-control input-sm"
                           name="up_writer" id="up_writer" style="width: 120px;">
                </td>

            </tr>
            <tr>
                <th>남기는말</th>
                <td>
                 <textarea style="width: 300px; height: 100px;"
                           class="form-control" name="up_content" id="up_content"></textarea>
                </td>
            </tr>
            <tr>
                <th>아바타</th>
                <td>
                    <input type="hidden" name="up_avata" id="up_avata">
                    <script type="text/javascript">
                        var s="";
                        for(var i=1;i<=10;i++){
                            s+="<img src='../image/avata/0"+i+".png' width='50' class='up_avata'>";

                            if(i==5)
                                s+="<br>";
                        }

                        document.write(s);
                    </script>
                    <input type="hidden", name="num_for_update" id="num_for_update">
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="button" class="btn btn-info"
                            id="up_dbSave">수정하기</button>
                </td>
            </tr>
        </table>
    </form>
</div>--%>
<div class="hello updateform">
    <form id="updatefrm">
        <!-- hidden :num 수정폼에서 가장중요함!!!!!항상보내기 -->
        <input type="hidden" id="num_for_update" name="num_for_update" value="">
        <table class="table table-bordered">
            <caption align="top"><b>방명록수정</b></caption>
            <tr>
                <th>작성자</th>
                <td>
                    <input type="text" class="form-control input-sm"
                           name="up_writer" id="up_writer" style="width: 120px;">
                </td>

            </tr>
            <tr>
                <th>남기는말</th>
                <td>
                 <textarea style="width: 300px; height: 100px;"
                           class="form-control" name="up_content" id="up_content"></textarea>
                </td>
            </tr>
            <tr>
                <th>아바타</th>
                <td>
                    <input type="hidden" name="up_avata" id="up_avata">
                    <script type="text/javascript">
                        var s="";
                        for(var i=1;i<=10;i++){
                            for(var i=1;i<=10;i++){
                                s+="<img src='../image/avata/0"+i+".png' width='50' class='up_avata'>";

                                if(i==5)
                                    s+="<br>";
                            }

                        }

                        document.write(s);
                    </script>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="button" class="btn btn-info"
                            id="up_dbSave">DB수정하기</button>
                </td>
            </tr>
        </table>
    </form>




</div>


<div class="hello list">list</div>
</body>
</html>