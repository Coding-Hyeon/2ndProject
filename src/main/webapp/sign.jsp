<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="SignupController" method="post">
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id" required><br><br>
        <label for="pw">비밀번호:</label>
        <input type="password" id="pw" name="pw" required><br><br>
        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br><br>
        <label for="gender">성별:</label>
        <select id="gender" name="gender">
            <option value="M">남자</option>
            <option value="F">여자</option>
        </select><br><br>
        <label for="date">생년월일:</label>
        <input type="date" id="date" name="date" required><br><br>
        <label for="region">지역:</label>
        <input type="text" id="region" name="region" required><br><br>
        <button type="submit">가입하기</button>
    </form>
    <br>
    <button onclick="location.href='login.jsp'">로그인으로 돌아가기</button>
</body>
</html>