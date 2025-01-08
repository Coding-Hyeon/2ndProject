<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="SignupController" method="post">
	    <input type="text" name="id" placeholder="ID" required>
	    <input type="password" name="pw" placeholder="Password" required>
	    <input type="text" name="name" placeholder="이름" required>
	    <select name="gender">
	        <option value="M">남성</option>
	        <option value="F">여성</option>
	    </select>
	    <input type="date" name="date" required>
	    <input type="text" name="region" placeholder="지역" required>
	    <button type="submit">가입하기</button>
	    <button type="button" onclick="history.back()">뒤로가기</button>
	</form>
</body>
</html>