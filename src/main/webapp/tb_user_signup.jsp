<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>회원가입</h1>
    <form action="SignupController" method="post">
        <label for="id">아이디:</label>
        <input type="text" id="id" name="id" required><br><br>

        <label for="pw">비밀번호:</label>
        <input type="password" id="pw" name="pw" required><br><br>

        <label for="name">이름:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label>성별:</label>
        <input type="radio" id="male" name="gender" value="M" required>
        <label for="male">남</label>
        <input type="radio" id="female" name="gender" value="F" required>
        <label for="female">여</label><br><br>

        <label for="date">생년월일:</label>
        <input type="date" id="date" name="date" required><br><br>

        <label for="region">지역:</label>
        <input type="text" id="region" name="region" required><br><br>

        <button type="submit">회원가입</button>
    </form>
</body>
</html>