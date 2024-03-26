<%@page import="data.dto.AnswerGuestDto"%>
<%@page import="data.dao.AnswerGuestDao"%>
<%@page import="data.dao.MemberDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.GuestDto"%>
<%@page import="java.util.List"%>
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
    <style type="text/css">

        span.day{
            float: right;
            font-size: 10pt;
            color: gray;
        }
        i.mod,i.del{
            cursor: pointer;
        }
    </style>

    <script type="text/javascript">
        $(function(){

            $("span.likes").click(function(){

                var num=$(this).attr("num");
                //alert(num);
                var tag=$(this);

                $.ajax({
                    type:"get",
                    dataType:"json",
                    url:"memberguest/updateincrechu.jsp",
                    data:{"num":num},
                    success:function(data){

                        // alert(data.chu);
                        tag.next().text(data.chu);

                        //하트에 animate
                        tag.next().next().animate({"font-size":"15px"},1000,function(){
                            //애니메이션 끝난후
                            $(this).css("font-size","0px");
                        })
                    }
                })
            });



            //삭제
            $("i.del").click(function(){
                var num=$(this).attr("num");
                var currentPage=$(this).attr("currentPage");

                //alert(num+","+currentPage);

                var yes=confirm("정말 삭제하시겠어요?");

                if(yes){
                    location.href='memberguest/delete.jsp?num='+num+'&currentPage='+currentPage;
                }

            })



            //댓글부분은 무조건 처음에는 안보이게 처리
            $("div.answer").hide();
            //댓글 클릭시 댓글부분이 보였다 안보였다 하기
            $("span.answer").click(function(){
                //$("div.answer").toggle();
                $(this).parent().find("div.answer").toggle();
            });


            //댓글삭제
            $("i.adel").click(function(){


                var a=confirm("삭제하려면 [확인]을 눌러주세요");

                if(a){

                    var idx=$(this).attr("idx");
                    //alert(idx);

                    $.ajax({
                        type:"get",
                        dataType:"html",
                        url:"memberguest/deleteanswer.jsp",
                        data:{"idx":idx},
                        success:function(){
                            location.reload();//새로고침
                        }
                    })

                }


            });



        });

    </script>
</head>
<body>
<%
    //로그인상태확인
    String loginok=(String)session.getAttribute("loginok");

    GuestDao dao=new GuestDao();

    //전체갯수
    int totalCount=dao.getTotalCount();
    int perPage=3; //한페이지당 보여질 글의 갯수
    int perBlock=5; //한블럭당 보여질 페이지 갯수
    int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이0번,오라클은 1번);
    int startPage; //각블럭당 보여질 시작페이지
    int endPage; //각블럭당 보여질 끝페이지
    int currentPage;  //현재페이지
    int totalPage; //총페이지수
    int no; //각페이지당 출력할 시작번호

    //현재페이지 읽는데 단 null일경우는 1페이지로 준다
    if(request.getParameter("currentPage")==null)
        currentPage=1;
    else
        currentPage=Integer.parseInt(request.getParameter("currentPage"));

    //총페이지수 구한다
    //총글갯수/한페이지당보여질갯수로 나눔(7/5=1)
    //나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
    totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);

    //각블럭당 보여질 시작페이지
    //perBlock=5일경우 현재페이지가 1~5일경우 시작페이지가1,끝페이지가 5
    //현재가 13일경우 시작:11 끝:15
    startPage=(currentPage-1)/perBlock*perBlock+1;
    endPage=startPage+perBlock-1;

    //총페이지가 23일경우 마지막블럭은 끝페이지가 25가 아니라 23
    if(endPage>totalPage)
        endPage=totalPage;

    //각페이지에서 보여질 시작번호
    //1페이지:0, 2페이지:5 3페이지: 10.....
    startNum=(currentPage-1)*perPage;

    //각페이지당 출력할 시작번호 구하기
    //총글개수가 23  , 1페이지:23 2페이지:18  3페이지:13
    no=totalCount-(currentPage-1)*perPage;

    //페이지에서 보여질 글만 가져오기
    List<GuestDto>list=dao.getList(startNum, perPage);


    /*마지막 페이지의 단 한개 남은 글을 삭제시 빈페이지가 남는다 그러므로 해결책은 그이전페이지로 가면 된다  */
    if(list.size()==0 && currentPage!=1)
    {%>
<script type="text/javascript">
    location.href="index.jsp?main=memberguest/guestlist.jsp?currentPge=<%=currentPage-1%>";
</script>
<%}


    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");

%>

<%
    if(loginok!=null){
%>
<jsp:include page="guestform.jsp"/>
<hr width="700" align="left" style="margin-left: 100px;">
<%}
%>
<div style="margin: 50px 100px;">
    <b>총 <%=totalCount %>개의 방명록 글이 있습니다</b>

    <%
        MemberDao mdao=new MemberDao();
        for(GuestDto dto:list)
        {
            //이름얻기
            String name=mdao.getName(dto.getMyid());
    %>

    <table  class="table" style="width: 580px;">
        <tr>
            <td>
                <b><i class="bi bi-person-circle"></i>&nbsp;<%=name %>(<%=dto.getMyid() %>)</b>

                <%
                    String myid=(String)session.getAttribute("myid");

                    //로그인한 아이디와 글을쓴아이디가 같을경우에만 수정,삭제 보이게한다
                    if(loginok!=null && dto.getMyid().equals(myid)){
                %>
                <span style="margin-left: 280px;">
    	    	  <i class="bi bi-pencil-square mod"
                     onclick="location.href='index.jsp?main=memberguest/updateform.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>'"></i>
    	    	  <i class="bi bi-trash del"
                     num=<%=dto.getNum() %>  currentPage=<%=currentPage %>></i></span>
                <%}
                %>

                <span class="day"><%=sdf.format(dto.getWriteday()) %></span>
            </td>
        </tr>

        <tr height="120">
            <td>
                <!-- 이미지가 null이아닌경우만 출력 -->
                <%
                    if(dto.getPhotoname()!=null){%>

                <a href="save/<%=dto.getPhotoname()%>" target="_blank">
                    <img alt="" src="save/<%=dto.getPhotoname()%>" align="left"
                         style="width: 100px; " hspace="20">
                </a>
                <%}
                %>

                <%=dto.getContent().replace("\n", "<br>")%>
            </td>
        </tr>

        <!-- 댓글&추천 -->
        <tr>
            <td>

                <%
                    //각방명록에 달린 댓글 목록가져오기
                    AnswerGuestDao adao=new AnswerGuestDao();
                    List<AnswerGuestDto> alist=adao.getAllAnswers(dto.getNum());
                %>


                <span class="answer" style="cursor: pointer;">댓글 <%=alist.size() %></span>
                <span class="likes" style="margin-left: 20px; cursor: pointer;" num=<%=dto.getNum() %>>추천</span>
                <span class="chu"><%=dto.getChu() %></span>
                <i class="bi bi-heart-fill" style="font-size: 0px; color: red;"></i>


                <div  class="answer">
                    <%
                        if(loginok!=null){%>

                    <div class="answerform">
                        <form action="memberguest/answerinsert.jsp" method="post">
                            <input type="hidden" name="num" value="<%=dto.getNum()%>">
                            <input type="hidden" name="myid" value="<%=myid%>">
                            <input type="hidden" name="currentPage" value="<%=currentPage%>">

                            <table>
                                <tr>
                                    <td width="500">
    	        	               <textarea style="width: 480px; height: 70px;"
                                             name="content" required="required"
                                             class="form-control"></textarea>
                                    </td>
                                    <td>
                                        <button type="submit" class="btn btn-info"
                                                style="width: 70px; height: 70px;">등록</button>
                                    </td>
                                </tr>
                            </table>
                        </form>
                    </div>
                    <% }
                    %>

                    <div class="answerlist">
                        <table style="width: 500px;" >
                            <%
                                for(AnswerGuestDto adto:alist)
                                {%>
                            <tr>
                                <td>
                                    <i class="bi bi-person-circle fs-2" style="color: gray;"></i>
                                </td>
                                <td>


                                    <%
                                        //작성자명
                                        String aname=mdao.getName(adto.getMyid());
                                    %>
                                    <br>
                                    <b><%=aname %></b>
                                    &nbsp;

                                    <%
                                        //글작성자와 댓글작성자가 같을경우
                                        if(dto.getMyid().equals(adto.getMyid())){%>

                                    <span style="color: red;">작성자</span>
                                    <%}
                                    %>

                                    <span style="font-size: 9pt; color: gray; margin-left: 20px;">
    	                	         <%=sdf.format(adto.getWriteday()) %>
    	                	      </span>


                                    <!-- 댓글 수정삭제는 본인만 보이게 -->
                                    <%
                                        if(loginok!=null && adto.getMyid().equals(myid)){%>

                                    <i class="aedit bi bi-pencil-square" idx="<%=adto.getIdx()%>"  data-bs-toggle="modal" data-bs-target="#myModal"></i>
                                    <i class="bi bi-trash adel" idx="<%=adto.getIdx()%>"></i>
                                    <%}
                                    %>

                                    <br>
                                    <span style="font-family: 10pt;"><%=adto.getContent().replace("\n", "<br>") %></span>

                                </td>
                            </tr>
                            <%}
                            %>
                        </table>
                    </div>
                </div>
            </td>
        </tr>
    </table>
    <%}
    %>
</div>

<!-- 페이지 번호 출력 -->
<div style="width: 580px; text-align: center; margin: 50px 100px;">

    <ul class="pagination justify-content-center">
        <%
            //이전
            if(startPage>1)
            {%>
        <li class="page-item ">
            <a class="page-link" href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=startPage-1%>" style="color: black;">이전</a>
        </li>
        <%}
            for(int pp=startPage;pp<=endPage;pp++)
            {
                if(pp==currentPage)
                {%>
        <li class="page-item active">
            <a class="page-link" href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
        </li>
        <%}else
        {%>
        <li class="page-item">
            <a class="page-link" href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
        </li>
        <%}
        }

            //다음
            if(endPage<totalPage)
            {%>
        <li class="page-item">
            <a  class="page-link" href="index.jsp?main=memberguest/guestlist.jsp?currentPage=<%=endPage+1%>"
                style="color: black;">다음</a>
        </li>
        <%}
        %>

    </ul>


</div>


<!-- The Modal -->
<div class="modal" id="myModal">
    <div class="modal-dialog">
        <div class="modal-content">

            <!-- Modal Header -->
            <div class="modal-header">
                <h4 class="modal-title">댓글수정</h4>
                <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
            </div>

            <!-- Modal body -->
            <div class="modal-body">
                <div class="updateform">
                    <input type="text" id="idx">
                    <input type="text" id="ucontent">
                    <button type="button" class="btn btn-info" id="btnupdate">댓글수정</button>
                </div>
            </div>

            <!-- Modal footer -->
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Close</button>
            </div>

        </div>
    </div>
</div>






</body>
</html>