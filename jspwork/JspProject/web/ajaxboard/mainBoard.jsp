<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap"
        rel="stylesheet">
  <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
  <style>
    div.list {
      position: relative;
      border: 1px solid gray;
    }

    div.writeform {
      position: relative;
      border: 1px solid gray;
    }

    div.list,
    div.writeform {
      font-family: 'Nanum Pen Script';
      font-size: 13pt;
    }

    .styled-table {
      width: 100%;
      border-collapse: collapse;
      border: 1px solid #ddd;
    }

    .styled-table th{
      padding: 8px;
      text-align: center;
      border-bottom: 1px solid #ddd;
    }


    .styled-table td {
      padding: 8px;
      text-align: left;
      border-bottom: 1px solid #ddd;
    }

    .styled-table th {
      background-color: #f2f2f2;
    }

    @media screen and (min-width: 768px) {
      div.list,
      div.writeform {
        position: absolute;
      }

      div.list {
        left: 100px;
        top: 100px;
      }

      div.writeform {
        left: 900px;
        top: 100px;
      }
      td.detail:hover {
        cursor: pointer;
      }
    }
  </style>
  <script>

    $(function () {
      list();

      //입력폼 처음에는 안보이게
      $("div.writeform").hide();
      $("div.updateform").hide();

      //글쓰기버튼 누르면 보이게
      $("#btnWrite").click(function () {
        $("div.writeform").slideToggle();
      });

      $("#btnSave").click(function () {
        const writer = $("#writer").val();
        const subject = $("#subject").val();
        const avata = $("#avata").val();
        const content = $("#content").val();

        $.ajax({
          type: "get",
          dataType: "json",
          url: "insertBoard.jsp",
          data: {
            "writer": writer,
            "subject": subject,
            "avata": avata,
            "content": content
          },
          success: function (res) {
            list();
            $("#writer").val("");
            $("#subject").val("");
            $("#avata").val("");
            $("#content").val("");


            //입력폼 사라지게
            $("div.writeform").hide();
          },
          error: function (xhr, status, error) {
            console.error("AJAX 오류: " + status + " - " + error);

          },
        })
      });

      $(document).on("click","td.detail",function(){

        //span태그에 넣어둔 num가져오기
        const num = $(this).data("num");
        //alert(num);

        $.ajax({

          type:"get",
          dataType:"json",
          data:{"num":num},
          url:"readBoard.jsp",
          success:function(data){

            // alert(data.writer);
            var s="<table class='table table-bordered' style='width:500px;'>";
            s+="<caption align='top'><b>디테일페이지 내용보기</b></caption>";
            s+="<tr class='table-input'>";
            s+="<td><b style='font-size:2em;'>"+data.subject+"</b>";
            s+="&nbsp;&nbsp;&nbsp;("+data.writer+")";
            s+="<span style='float:right; color:gray;'>"+data.writeday+"</span></td></tr>";
            s+="<tr><td>";
            s+="<img src='"+data.avata+"' align='left' hspace='20'>";
            s+="<pre>"+data.content+"</pre></td></tr>";

            //버튼들
            s+="<tr><td align='right'>";
            s+="<button type='button' class='btn btn-success btn-sm btnlist'>목록</button>";
            s+="<button type='button' class='btn btn-warning btn-sm btnupdate' num='"+data.num+"'>수정</button>";
            s+="<button type='button' class='btn btn-danger btn-sm btndelete' num='"+data.num+"'>삭제</button>";
            s+="</td></tr>";
            s+="</table>";

            //출력
            $("div.detail").html(s);

            //list숨기고 detail보이게
            $("div.list").hide();
            $("div.detail").show();
          }
        });
      });

      $(document).on("click", ".btndelete", function () {
        const num = $(this).attr("num");

        $.ajax({
          type: "get",
          url: "deleteBoard.jsp",
          dataType: "json",
          data:{
            "num":num
          },
          success: function (res) {
            console.log({res});
            list();
            $("div.list").show();
            $("div.detail").hide();
          },
        })
      });

      $(document).on("click", ".btnlist", function () {
        list();
        $("div.list").show();
        $("div.detail").hide();

      });


      $(document).on("click", ".btnupdate", function () {
        //span태그에 넣어둔 num가져오기
        const num = $(this).attr("num");
        //alert(num);

        $.ajax({

          type:"get",
          dataType:"json",
          data:{"num":num},
          url:"readBoard.jsp",
          success:function(data){


            $("#up_writer").val(data.writer);
            $("#up_subject").val(data.subject);
            $("#up_content").val(data.content);
            $("#up_avata").val(data.avata);

            $("div.updateform").show();
          }
      });
    });


      $(document).on("click", ".btnupdate", function () {
        //span태그에 넣어둔 num가져오기
        const num = $(this).attr("num");
        //alert(num);

        $.ajax({

          type:"get",
          dataType:"json",
          data:{"num":num},
          url:"readBoard.jsp",
          success:function(data){


            $("#up_writer").val(data.writer);
            $("#up_subject").val(data.subject);
            $("#up_content").val(data.content);
            $("#up_avata").val(data.avata);
            $("#num_for_update").val(data.num);

            $("div.updateform").show();
          }
        });
      });

      $("#btnDBUpdate").click(function () {
        //span태그에 넣어둔 num가져오기num_for_update
        const num = $("#num_for_update").val();
        const writer = $("#up_writer").val();
        const subject = $("#up_subject").val();
        const avata = $("#up_avata").val();
        const content = $("#up_content").val();

        console.log({num,writer,subject,avata, content})

        //alert(num);

        $.ajax({

          type:"get",
          dataType:"json",
          data:{
            "num":num,
            "writer":writer,
            "subject":subject,
            "avata": avata,
            "content":content
          },
          url:"updateBoard.jsp",
          success:function(res){
            console.log({res});

            $("div.updateform").hide();
            list();
            $("div.list").show();
            $("div.detail").hide();
          }
        });
      });


      function list() {
      var s = "";
      $.ajax({
        type: "get",
        dataType: "json",
        url: "listBoard.jsp",
        success: function (res) {


          var s = "<table class='styled-table'>";
          s += "<thead><tr>";
          s += "<th>번호</th>"; // 번호
          s += "<th>글쓴이</th>"; // 글쓴이
          s += "<th>제목</th>"; // 제목
          s += "<th>내용</th>"; // 내용
          s += "<th>감정</th>"; // 감정
          s += "<th>작성일</th>"; // 작성일
          s += "</tr></thead>";
          s += "<tbody>";
          for (var i = 0; i < res.length; i++) {
            s += "<tr>";
            s += "<td>" + (res.length-i) + "</td>"; // 번호
            s += "<td>" + res[i].writer + "</td>"; // 글쓴이
            s += "<td>" + res[i].subject + "</td>"; // 제목
            s += "<td class='detail' data-num='"+res[i].num+"'>" + res[i].content + "</td>"; // 내용
            s += "<td><img style='max-height: 30px' src='" + res[i].avata + "'</img></td>"; // 감정
            s += "<td>" + res[i].writeday + "</td>"; // 작성일
            s += "</tr>";
          }
          s += "</tbody>";
          s += "</table>";
          $("#boardList").html(s);
        },
        error: function (xhr, status, error) {
          console.error(error);
        }
      })
    }
    })


  </script>
</head>
<body>
<div class="container">
  <div class="row">
    <div class="col-12 col-md-6">
      <div class="list">
        <button type="button" class="btn btn-info" id="btnWrite">글쓰기</button>
        <div id="boardList">list</div>
      </div>

    </div>

    <div class="detail"></div>
    <div class="updateform">
      <form action="#">
        <table class="table table-bordered">
          <caption align="top"><b>게시글 수정</b></caption>
          <tr>
            <th class="table-primary">작성자</th>
            <td>
              <input type="text" id="up_writer" style="width: 120px;" class="form-control">
            </td>
          </tr>
          <tr>
            <th class="table-primary">제목</th>
            <td>
              <input type="text" id="up_subject" style="width: 200px;" class="form-control">
            </td>
          </tr>

          <tr>
            <th class="table-primary">아바타</th>
            <td>
              <select name="" id="up_avata" class="form-control">
                <option value="../image/avata/01.png">사랑해</option>
                <option value="../image/avata/02.png">최고</option>
                <option value="../image/avata/03.png">신남</option>
                <option value="../image/avata/04.png">좌절</option>
                <option value="../image/avata/05.png">배고파</option>
                <option value="../image/avata/06.png">심심함</option>

              </select>
            </td>
          </tr>
          <tr>
            <td colspan="2">
                                <textarea name="" id="up_content" class="form-control" cols="30" rows="10"
                                          style="width: 380px;height: 100px;"></textarea>
            </td>
          </tr>

          <tr>
            <td colspan="2" align="center">
              <button type="button" class="btn btn-danger" id="btnDBUpdate">DB 수정</button>
              <input type="hidden" id="num_for_update">

            </td>
          </tr>
        </table>

      </form>
    </div>
    <div class="col-12 col-md-6">
      <div class="writeform">
        <form action="#">
          <table class="table table-bordered">
            <caption align="top"><b>게시글추가</b></caption>
            <tr>
              <th class="table-primary">작성자</th>
              <td>
                <input type="text" id="writer" style="width: 120px;" class="form-control">
              </td>
            </tr>
            <tr>
              <th class="table-primary">제목</th>
              <td>
                <input type="text" id="subject" style="width: 200px;" class="form-control">
              </td>
            </tr>

            <tr>
              <th class="table-primary">아바타</th>
              <td>
                <select name="" id="avata" class="form-control">
                  <option value="../image/avata/01.png">사랑해</option>
                  <option value="../image/avata/02.png">최고</option>
                  <option value="../image/avata/03.png">신남</option>
                  <option value="../image/avata/04.png">좌절</option>
                  <option value="../image/avata/05.png">배고파</option>
                  <option value="../image/avata/06.png">심심함</option>

                </select>
              </td>
            </tr>
            <tr>
              <td colspan="2">
                                <textarea name="" id="content" class="form-control" cols="30" rows="10"
                                          style="width: 380px;height: 100px;"></textarea>
              </td>
            </tr>

            <tr>
              <td colspan="2" align="center">
                <button type="button" class="btn btn-danger" id="btnSave">DB 추가</button>

              </td>
            </tr>
          </table>

        </form>
      </div>
    </div>
  </div>
</div>

</body>
</html>
