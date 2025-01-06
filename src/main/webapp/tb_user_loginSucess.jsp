<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>환영합니다, <c:out value="${loginUser.name}"/>님!</h1>
    <p>성별: <c:out value="${loginUser.gender}"/></p>
    <p>지역: <c:out value="${loginUser.region}"/></p>
    <a href="logout">로그아웃</a>
</body>
</html>