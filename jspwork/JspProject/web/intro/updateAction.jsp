<%@ page import="intro.model.IntroDao" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="intro.model.IntroDto" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gamja+Flower&family=Gowun+Dodum&family=IBM+Plex+Sans+KR&family=Noto+Sans+KR:wght@100..900&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    MultipartRequest multi=null;

    ServletContext context=getServletConfig().getServletContext();
    String realFolder=context.getRealPath("introphoto");
    int fileSize=1024*1024*5;

    multi=new MultipartRequest(request,realFolder,fileSize,"utf-8",new DefaultFileRenamePolicy());

    String name =  multi.getParameter("name");
    String age =  multi.getParameter("age");
    String uploadFileName=multi.getFilesystemName("uploadFile");
    String birthday =  multi.getParameter("birthday");
    String hometown =  multi.getParameter("hometown");
    String []hobby =  multi.getParameterValues("hobby");
    String memo =  multi.getParameter("memo");
    String num = multi.getParameter("num");

    String hobbys ="";

    if (hobby == null) {
        hobbys="";
    }else{
        for (int i = 0; i < hobby.length; i++) {
            hobbys+= hobby[i];
            if (i < hobby.length - 1) {
                hobbys+=",";
            }
        }
    }

%>

<%--<jsp:useBean id="dao" class="intro.model.IntroDao"></jsp:useBean>--%>
<%--<jsp:useBean id="dto" class="intro.model.IntroDto"></jsp:useBean>--%>

<%--<jsp:setProperty property="*" name="dto"/>--%>

<%
    IntroDao dao = new IntroDao();
    IntroDto dto =new IntroDto();

    dto.setName(name);
    dto.setAge(age);
    dto.setPhoto("../introphoto/"+uploadFileName);
    dto.setBirthday(birthday);
    dto.setHometown(hometown);
    dto.setHobby(hobbys);
    dto.setMemo(memo);
    dto.setNum(num);

    dao.updateIntro(dto);


    //String hobby=request.getParameter("hobby");
    response.sendRedirect("introList.jsp");
%>
</body>
</html>