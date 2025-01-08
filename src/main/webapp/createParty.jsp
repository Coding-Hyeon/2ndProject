<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="createParty" method="post" enctype="multipart/form-data">
	    <input type="text" name="party_nm" placeholder="모임방 제목" required>
	    <textarea name="party_info" placeholder="소개"></textarea>
	    <input type="text" name="party_region" placeholder="지역" required>
	    <input type="file" name="party_file">
	    <button type="submit">생성</button>
	</form>
	<button type="button" onclick="history.back()">뒤로가기</button>
</body>
</html>