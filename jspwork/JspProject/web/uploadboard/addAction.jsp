<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="java.io.IOException" %>
<%@ page import="uploadboard.data.UploadBoardDto" %>
<%@ page import="uploadboard.data.UploadBoardDao" %><%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2024-03-13
  Time: 오후 12:14
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
<%
    request.setCharacterEncoding("UTF-8");

    //업로드에 필요한 변수선언
    //업로드할 경로(톰캣에 올라가는 프로젝트경로)
    String realFolder = getServletConfig().getServletContext().getRealPath("/save");
    System.out.println(realFolder);

    //업로드 사이즈
    int uploadSize = 1024 * 1024 * 3; //3mb

    //생성자파라메터(request,업로드폴더,업로드사이즈,한글,같은이름일경우 1,2,3 붙이기)

    try {
        MultipartRequest multi = new MultipartRequest(request, realFolder, uploadSize,"UTF-8",
        new DefaultFileRenamePolicy());

        //입력값 읽기
        String writer = multi.getParameter("writer");
        String subject = multi.getParameter("subject");
        String content = multi.getParameter("content");
        String pass = multi.getParameter("pass");

        //실제 업로드 이미지이름 읽어오기
        String imgname = multi.getFilesystemName("photo");

        //dto에 담기
        UploadBoardDto dto = new UploadBoardDto();

        dto.setWriter(writer);
        dto.setSubject(subject);
        dto.setContent(content);
        dto.setPass(pass);
        dto.setImgname(imgname);

        UploadBoardDao dao = new UploadBoardDao();
        dao.insertUploadBoard(dto);

        System.out.println(dto.getNum());
        System.out.println(dto.getWriter());
        System.out.println(dto.getSubject());
        System.out.println(dto.getContent());
        System.out.println(dto.getImgname());
        System.out.println(dto.getPass());

        response.sendRedirect("boardList.jsp");

    } catch (IOException e) {
        e.getStackTrace();
    }
%>

</body>
</html>
