<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
	    <input type="text" name="user_id" placeholder="ID" required>
	    <input type="password" name="user_pw" placeholder="Password" required>
	    <button type="submit">로그인</button>
	    <button type="button" onclick="location.href='signup.jsp'">회원가입</button>
	</form>
</body>
</html>