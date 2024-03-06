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
<div style="margin: 30px 50px;">
    <form action="addAction.jsp" method="post" enctype="multipart/form-data">
        <table class="table table-bordered" style="width:600px">
            <caption align="top"><b>자기소개</b></caption>
            <tr>
                <th>이름</th>
                <td>
                    <input type="text" name="name" class="form-control" required="required" style="width:80px">
                </td>
            </tr>

            <tr>
                <th>나이</th>
                <td>
                    <input type="number" name="age" class="form-control" value="20" style="width:60px">
                </td>
            </tr>
            <tr>
                <th>사진</th>
                <td>
                    <input type="file" name="uploadFile" class="form-control" style="width:450px">
                </td>
            </tr>

            <tr>
                <th>생년월일</th>
                <td>
                    <input type="date" name="birthday" class="form-control" value="1997-02-25" style="width:200px">
                </td>
            </tr>

            <tr>
                <th>거주지역</th>
                <td>
                    <label><input type="radio" name="hometown" value="서울" checked="checked">서울</label>
                    <label><input type="radio" name="hometown" value="서울">경기</label>
                    <label><input type="radio" name="hometown" value="서울">인천</label>
                    <label><input type="radio" name="hometown" value="서울">강원</label>
                    <label><input type="radio" name="hometown" value="서울">대구</label>
                </td>
            </tr>

            <tr>
                <th>취미</th>
                <td>
                    <label><input type="checkbox" name="hobby" value="게임">게임</label>
                    <label><input type="checkbox" name="hobby" value="넷플릭스">넷플릭스</label>
                    <label><input type="checkbox" name="hobby" value="독서">독서</label>
                    <label><input type="checkbox" name="hobby" value="여행">여행</label>
                    <label><input type="checkbox" name="hobby" value="공부">공부</label>
                </td>
            </tr>

            <tr>
                <th>성격</th>
                <td>
                    <textarea style="width:500px; height:100px" placeholder="자유롭게 서술하세요." class="form-control" name="memo"></textarea>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <button type="submit" class="btn btn-outline-success">서버로 전송</button>
                </td>
            </tr>
        </table>

    </form>

</div>
</body>
</html>