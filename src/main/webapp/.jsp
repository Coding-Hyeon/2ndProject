<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <header>
        <button onclick="location.href='main.jsp'">메인으로</button>
        <button onclick="location.href='logout'">로그아웃</button>
    </header>
    <h2>모임 생성</h2>
    <form action="createParty" method="post" enctype="multipart/form-data">
        <label for="partyNm">모임 이름:</label>
        <input type="text" id="partyNm" name="partyNm" required><br><br>

        <label for="partyInfo">모임 소개:</label>
        <textarea id="partyInfo" name="partyInfo" required></textarea><br><br>

        <label for="partyRegion">지역:</label>
        <input type="text" id="partyRegion" name="partyRegion" required><br><br>

        <label for="partyFile">모임 이미지:</label>
        <input type="file" id="partyFile" name="partyFile"><br><br>

        <button type="submit">모임 생성</button>
    </form>
</body>
</html>