<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="login" method="post">
        <label for="user_id">아이디:</label>
        <input type="text" id="user_id" name="user_id" required><br><br>
        <label for="user_pw">비밀번호:</label>
        <input type="password" id="user_pw" name="user_pw" required><br><br>
        <button type="submit">로그인</button>
    </form>
    <br>
    <button onclick="location.href='sign.jsp'">회원가입</button>
</body>
</html>