<%--
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
    <script>
        function previewImage(event) {
            var preview = document.getElementById('preview');
            if(event.target.files.length > 0) {
                // FileReader 객체 생성
                var reader = new FileReader();

                // 이미지가 로드되었을 때 실행할 함수 설정
                reader.onload = function(event) {
                    preview.src = event.target.result; // 생성된 URL을 img 요소의 src 속성에 할당
                    preview.style.display = 'block'; // 이미지를 보이게 설정
                };

                // 파일을 읽어 URL을 생성
                reader.readAsDataURL(event.target.files[0]);
            } else {
                preview.style.display = 'none'; // 파일이 없으면 이미지를 숨김
            }
        }
    </script>
</head>
<body>
<div style="margin: 50px 100px; width: 500px;">
    <form action="addAction.jsp" method="post" enctype="multipart/form-data">
        <table class="table table-bordered">
            <tr>
                <th width="100" class="table-info"> 작성자 </th>
                <td>
                    <input type="text" name="writer" class="form-control"
                    style="width: 120px;" required>
                </td>
            </tr>
            <tr>
                <th width="100" class="table-info">제목</th>
                <td>
                    <input type="text" name="subject" class="form-control"
                    style="width: 300px;" required>
                </td>
            </tr>

            <tr>
                <th width="100" class="table-info">사진업로드</th>
                <td>
                    <input type="file" name="photo" class="form-control"
                    style="width: 300px;" required onchange="previewImage(event)">
                </td>
            </tr>
            <tr>
                <th width="100" class="table-info">비밀번호</th>
                <td><input type="text" name="pass" class="form-control"
                style="width: 200px" required></td>
            </tr>

            <tr>
                <td colspan="2">
                    <textarea name="content" id="" cols="30" rows="10"
                    style="width: 400px; height: 100px" class="form-control" required ></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <button type="submit" style="width: 100px;"
                    class="btn btn-success btn-md">저장하기</button>
                    <button type="button" style="width: 100px;"
                    class="btn btn-warning btn-md" onclick="location.href='boardList.jsp'">목록보기</button>
                </td>
            </tr>
        </table>
        <img id="preview" src="" height="200" alt="Image preview..." style="display: none;">
    </form>
    
</div>

</body>
</html>
