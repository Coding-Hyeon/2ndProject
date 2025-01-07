<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <header>
        <button onclick="location.href='mypage.jsp'">마이페이지</button>
        <button onclick="location.href='logout'">로그아웃</button>
    </header>
    <h2>메인 화면</h2>
    <button onclick="location.href='findGroups.jsp'">모임 찾기</button>
    <button onclick="location.href='myGroups.jsp'">나의 모임</button>
</body>
</html>